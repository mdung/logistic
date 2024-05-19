package com.intelligent.logistics.services;

import com.intelligent.logistics.models.Report;
import com.intelligent.logistics.models.TrackingInfo;
import com.intelligent.logistics.repositories.DeliveryOrderRepository;
import com.intelligent.logistics.repositories.VehicleRepository;
import com.intelligent.logistics.repositories.TrackingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final DeliveryOrderRepository deliveryOrderRepository;
    private final VehicleRepository vehicleRepository;
    private final TrackingInfoRepository trackingInfoRepository;

    @Autowired
    public ReportService(DeliveryOrderRepository deliveryOrderRepository,
                         VehicleRepository vehicleRepository,
                         TrackingInfoRepository trackingInfoRepository) {
        this.deliveryOrderRepository = deliveryOrderRepository;
        this.vehicleRepository = vehicleRepository;
        this.trackingInfoRepository = trackingInfoRepository;
    }

    public Report generateSummaryReport() {
        Report report = new Report();
        report.setTotalDeliveries(deliveryOrderRepository.count());
        report.setTotalVehicles(vehicleRepository.count());
        report.setTotalDistanceTraveled(calculateTotalDistance());
        report.setAverageDeliveryTime(calculateAverageDeliveryTime());
        return report;
    }

    private long calculateTotalDistance() {
        long totalDistance = 0;

        List<Long> deliveryOrderIds = deliveryOrderRepository.findAll().stream()
                .map(deliveryOrder -> deliveryOrder.getId())
                .collect(Collectors.toList());

        for (Long deliveryOrderId : deliveryOrderIds) {
            List<TrackingInfo> trackingInfos = trackingInfoRepository.findByDeliveryOrderId(deliveryOrderId);
            for (int i = 1; i < trackingInfos.size(); i++) {
                TrackingInfo prev = trackingInfos.get(i - 1);
                TrackingInfo curr = trackingInfos.get(i);
                totalDistance += calculateDistance(prev.getLatitude(), prev.getLongitude(), curr.getLatitude(), curr.getLongitude());
            }
        }

        return totalDistance;
    }

    private double calculateAverageDeliveryTime() {
        double totalDeliveryTime = 0;
        long totalDeliveries = deliveryOrderRepository.count();

        List<TrackingInfo> allTrackingInfos = trackingInfoRepository.findAll();

        List<Long> distinctDeliveryOrderIds = allTrackingInfos.stream()
                .map(trackingInfo -> trackingInfo.getDeliveryOrder().getId())
                .distinct()
                .collect(Collectors.toList());

        for (Long deliveryOrderId : distinctDeliveryOrderIds) {
            List<TrackingInfo> trackingInfos = trackingInfoRepository.findByDeliveryOrderId(deliveryOrderId);

            if (!trackingInfos.isEmpty()) {
                LocalDateTime startTime = trackingInfos.get(0).getTimestamp();
                LocalDateTime endTime = trackingInfos.get(trackingInfos.size() - 1).getTimestamp();

                totalDeliveryTime += Duration.between(
                        startTime.atZone(ZoneOffset.UTC).toInstant(),
                        endTime.atZone(ZoneOffset.UTC).toInstant()
                ).toMinutes();
            }
        }

        return totalDeliveryTime / totalDeliveries;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        return distance;
    }
}
