-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 02:35 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `route_optimization_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `delivery_order`
--

CREATE TABLE `delivery_order` (
  `id` bigint(20) NOT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `volume` int(11) NOT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  `parent_delivery_order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `delivery_order`
--

INSERT INTO `delivery_order` (`id`, `customer_name`, `delivery_address`, `delivery_time`, `volume`, `vehicle_id`, `parent_delivery_order_id`) VALUES
(1, 'John Doe', '123 Elm St, New York, NY', '2024-06-01 10:30:00', 300, 9, NULL),
(2, 'Jane Smith', '456 Oak St, Los Angeles, CA', '2024-06-02 14:00:00', 400, 2, NULL),
(3, 'Acme Corp', '789 Pine St, Chicago, IL', '2024-06-03 09:00:00', 500, 3, NULL),
(4, 'Global Industries', '101 Maple St, Houston, TX', '2024-06-04 16:30:00', 250, 4, NULL),
(5, 'XYZ Ltd', '202 Birch St, Phoenix, AZ', '2024-06-05 11:45:00', 350, 5, NULL),
(6, 'MegaStore', '303 Cedar St, Philadelphia, PA', '2024-06-06 15:00:00', 450, 6, NULL),
(7, 'Tech Solutions', '404 Walnut St, San Antonio, TX', '2024-06-07 13:15:00', 550, 7, NULL),
(8, 'Fast Delivery', '505 Spruce St, San Diego, CA', '2024-06-08 08:00:00', 600, 8, NULL),
(9, 'Logistics Inc', '606 Fir St, Dallas, TX', '2024-06-09 17:00:00', 400, 9, NULL),
(10, 'Retail Shop', '707 Hemlock St, San Jose, CA', '2024-06-10 12:30:00', 500, 10, NULL),
(11, 'Quick Deliveries', '808 Elm St, New York, NY', '2024-06-11 10:00:00', 200, 1, NULL),
(12, 'Green Supplies', '909 Oak St, Los Angeles, CA', '2024-06-12 14:30:00', 450, 2, NULL),
(13, 'Blue Electronics', '1010 Pine St, Chicago, IL', '2024-06-13 09:30:00', 600, 3, NULL),
(14, 'Red Industries', '1111 Maple St, Houston, TX', '2024-06-14 16:00:00', 300, 4, NULL),
(15, 'White Goods', '1212 Birch St, Phoenix, AZ', '2024-06-15 12:00:00', 400, 5, NULL),
(16, 'MegaMart', '1313 Cedar St, Philadelphia, PA', '2024-06-16 15:30:00', 500, 6, NULL),
(17, 'Tech Depot', '1414 Walnut St, San Antonio, TX', '2024-06-17 13:45:00', 550, 7, NULL),
(18, 'Speedy Shipping', '1515 Spruce St, San Diego, CA', '2024-06-18 08:30:00', 600, 8, NULL),
(19, 'Cargo Movers', '1616 Fir St, Dallas, TX', '2024-06-19 17:30:00', 450, 9, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tracking_info`
--

CREATE TABLE `tracking_info` (
  `id` bigint(20) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  `delivery_order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tracking_info`
--

INSERT INTO `tracking_info` (`id`, `latitude`, `longitude`, `timestamp`, `delivery_order_id`) VALUES
(21, 40.712776, -74.005974, '2024-06-01 10:35:00', 1),
(22, 40.713776, -74.004974, '2024-06-01 10:40:00', 1),
(23, 40.714776, -74.003974, '2024-06-01 10:45:00', 1),
(24, 40.715776, -74.002974, '2024-06-01 10:50:00', 1),
(25, 40.716776, -74.001974, '2024-06-01 10:55:00', 1),
(26, 34.052235, -118.243683, '2024-06-02 14:05:00', 2),
(27, 34.053235, -118.242683, '2024-06-02 14:10:00', 2),
(28, 34.054235, -118.241683, '2024-06-02 14:15:00', 2),
(29, 34.055235, -118.240683, '2024-06-02 14:20:00', 2),
(30, 34.056235, -118.239683, '2024-06-02 14:25:00', 2),
(31, 41.878113, -87.629799, '2024-06-03 09:05:00', 3),
(32, 41.879113, -87.628799, '2024-06-03 09:10:00', 3),
(33, 41.880113, -87.627799, '2024-06-03 09:15:00', 3),
(34, 41.881113, -87.626799, '2024-06-03 09:20:00', 3),
(35, 41.882113, -87.625799, '2024-06-03 09:25:00', 3),
(36, 29.760427, -95.369804, '2024-06-04 11:00:00', 4),
(37, 29.761427, -95.368804, '2024-06-04 11:05:00', 4),
(38, 29.762427, -95.367804, '2024-06-04 11:10:00', 4),
(39, 29.763427, -95.366804, '2024-06-04 11:15:00', 4),
(40, 29.764427, -95.365804, '2024-06-04 11:20:00', 4),
(41, 33.448376, -112.074036, '2024-06-05 15:20:00', 5),
(42, 33.449376, -112.073036, '2024-06-05 15:25:00', 5),
(43, 33.450376, -112.072036, '2024-06-05 15:30:00', 5),
(44, 33.451376, -112.071036, '2024-06-05 15:35:00', 5),
(45, 33.452376, -112.070036, '2024-06-05 15:40:00', 5),
(46, 39.739236, -104.990251, '2024-06-06 08:00:00', 6),
(47, 39.740236, -104.989251, '2024-06-06 08:05:00', 6),
(48, 39.741236, -104.988251, '2024-06-06 08:10:00', 6),
(49, 39.742236, -104.987251, '2024-06-06 08:15:00', 6),
(50, 39.743236, -104.986251, '2024-06-06 08:20:00', 6),
(51, 32.715736, -117.161087, '2024-06-07 13:20:00', 7),
(52, 32.716736, -117.160087, '2024-06-07 13:25:00', 7),
(53, 32.717736, -117.159087, '2024-06-07 13:30:00', 7),
(54, 32.718736, -117.158087, '2024-06-07 13:35:00', 7),
(55, 32.719736, -117.157087, '2024-06-07 13:40:00', 7),
(56, 29.424122, -98.493629, '2024-06-08 08:05:00', 8),
(57, 29.425122, -98.492629, '2024-06-08 08:10:00', 8),
(58, 29.426122, -98.491629, '2024-06-08 08:15:00', 8),
(59, 29.427122, -98.490629, '2024-06-08 08:20:00', 8),
(60, 29.428122, -98.489629, '2024-06-08 08:25:00', 8),
(61, 30.267153, -97.743057, '2024-06-09 10:00:00', 9),
(62, 30.268153, -97.742057, '2024-06-09 10:05:00', 9),
(63, 30.269153, -97.741057, '2024-06-09 10:10:00', 9),
(64, 30.270153, -97.740057, '2024-06-09 10:15:00', 9),
(65, 30.271153, -97.739057, '2024-06-09 10:20:00', 9),
(66, 29.951065, -90.071533, '2024-06-10 11:15:00', 10),
(67, 29.952065, -90.070533, '2024-06-10 11:20:00', 10),
(68, 29.953065, -90.069533, '2024-06-10 11:25:00', 10),
(69, 29.954065, -90.068533, '2024-06-10 11:30:00', 10),
(70, 29.955065, -90.067533, '2024-06-10 11:35:00', 10),
(71, 47.606209, -122.332069, '2024-06-11 12:30:00', 1),
(72, 47.607209, -122.331069, '2024-06-11 12:35:00', 1),
(73, 47.608209, -122.330069, '2024-06-11 12:40:00', 1),
(74, 47.609209, -122.329069, '2024-06-11 12:45:00', 1),
(75, 47.610209, -122.328069, '2024-06-11 12:50:00', 1),
(76, 34.052235, -118.243683, '2024-06-12 14:05:00', 2),
(77, 34.053235, -118.242683, '2024-06-12 14:10:00', 2),
(78, 34.054235, -118.241683, '2024-06-12 14:15:00', 2),
(79, 34.055235, -118.240683, '2024-06-12 14:20:00', 2),
(80, 34.056235, -118.239683, '2024-06-12 14:25:00', 2),
(81, 41.878113, -87.629799, '2024-06-13 09:05:00', 3),
(82, 41.879113, -87.628799, '2024-06-13 09:10:00', 3),
(83, 41.880113, -87.627799, '2024-06-13 09:15:00', 3),
(84, 41.881113, -87.626799, '2024-06-13 09:20:00', 3),
(85, 41.882113, -87.625799, '2024-06-13 09:25:00', 3),
(86, 29.760427, -95.369804, '2024-06-14 11:00:00', 4),
(87, 29.761427, -95.368804, '2024-06-14 11:05:00', 4),
(88, 29.762427, -95.367804, '2024-06-14 11:10:00', 4),
(89, 29.763427, -95.366804, '2024-06-14 11:15:00', 4),
(90, 29.764427, -95.365804, '2024-06-14 11:20:00', 4),
(91, 33.448376, -112.074036, '2024-06-15 15:20:00', 5),
(92, 33.449376, -112.073036, '2024-06-15 15:25:00', 5),
(93, 33.450376, -112.072036, '2024-06-15 15:30:00', 5),
(94, 33.451376, -112.071036, '2024-06-15 15:35:00', 5),
(95, 33.452376, -112.070036, '2024-06-15 15:40:00', 5),
(96, 39.739236, -104.990251, '2024-06-16 08:00:00', 6),
(97, 39.740236, -104.989251, '2024-06-16 08:05:00', 6),
(98, 39.741236, -104.988251, '2024-06-16 08:10:00', 6),
(99, 39.742236, -104.987251, '2024-06-16 08:15:00', 6),
(100, 39.743236, -104.986251, '2024-06-16 08:20:00', 6),
(101, 32.715736, -117.161087, '2024-06-17 13:20:00', 7),
(102, 32.716736, -117.160087, '2024-06-17 13:25:00', 7),
(103, 32.717736, -117.159087, '2024-06-17 13:30:00', 7),
(104, 32.718736, -117.158087, '2024-06-17 13:35:00', 7),
(105, 32.719736, -117.157087, '2024-06-17 13:40:00', 7),
(106, 29.424122, -98.493629, '2024-06-18 08:05:00', 8),
(107, 29.425122, -98.492629, '2024-06-18 08:10:00', 8),
(108, 29.426122, -98.491629, '2024-06-18 08:15:00', 8),
(109, 29.427122, -98.490629, '2024-06-18 08:20:00', 8),
(110, 29.428122, -98.489629, '2024-06-18 08:25:00', 8),
(111, 30.267153, -97.743057, '2024-06-19 10:00:00', 9),
(112, 30.268153, -97.742057, '2024-06-19 10:05:00', 9),
(113, 30.269153, -97.741057, '2024-06-19 10:10:00', 9),
(114, 30.270153, -97.740057, '2024-06-19 10:15:00', 9),
(115, 30.271153, -97.739057, '2024-06-19 10:20:00', 9),
(116, 29.951065, -90.071533, '2024-06-20 11:15:00', 10),
(117, 29.952065, -90.070533, '2024-06-20 11:20:00', 10),
(118, 29.953065, -90.069533, '2024-06-20 11:25:00', 10),
(119, 29.954065, -90.068533, '2024-06-20 11:30:00', 10),
(120, 29.955065, -90.067533, '2024-06-20 11:35:00', 10);

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `id` bigint(20) NOT NULL,
  `capacity` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `registration_number` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`id`, `capacity`, `location`, `model`, `registration_number`, `color`, `year`) VALUES
(1, 1000, 'New York', 'Ford Transit', 'NY-12345', 'White', 2018),
(2, 1200, 'Los Angeles', 'Mercedes Sprinter', 'LA-67890', 'Black', 2019),
(3, 1500, 'Chicago', 'Ram ProMaster', 'CH-11111', 'Silver', 2020),
(4, 800, 'Houston', 'Nissan NV200', 'HO-22222', 'Red', 2017),
(5, 950, 'Phoenix', 'Chevrolet Express', 'PH-33333', 'Blue', 2018),
(6, 1100, 'Philadelphia', 'Ford Transit Connect', 'PHI-44444', 'Grey', 2019),
(7, 1300, 'San Antonio', 'GMC Savana', 'SA-55555', 'Green', 2020),
(8, 1400, 'San Diego', 'Freightliner Sprinter', 'SD-66666', 'Yellow', 2017),
(9, 900, 'Dallas', 'Ford E-Series', 'DA-77777', 'Orange', 2018),
(10, 1250, 'San Jose', 'Ram ProMaster City', 'SJ-88888', 'Purple', 2019),
(11, 1223, 'Buffalo', 'Vinfast', 'GH-456344', 'Red', 2022),
(12, 12, 'NEWYORK', 'Vinfast', 'JH-9877', 'Green', 2022),
(13, 12, 'Miami', 'Mercedes', 'HH-8987', 'white', 2023);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `delivery_order`
--
ALTER TABLE `delivery_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKe2sbx5pogk5eceok6kgl7wn3j` (`vehicle_id`),
  ADD KEY `FKhhwp7xafu75bhev4kcvd8b6j7` (`parent_delivery_order_id`);

--
-- Indexes for table `tracking_info`
--
ALTER TABLE `tracking_info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsn5h6ojwrbt463ch00ifijkyv` (`delivery_order_id`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `delivery_order`
--
ALTER TABLE `delivery_order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `tracking_info`
--
ALTER TABLE `tracking_info`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery_order`
--
ALTER TABLE `delivery_order`
  ADD CONSTRAINT `FKe2sbx5pogk5eceok6kgl7wn3j` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
  ADD CONSTRAINT `FKhhwp7xafu75bhev4kcvd8b6j7` FOREIGN KEY (`parent_delivery_order_id`) REFERENCES `delivery_order` (`id`);

--
-- Constraints for table `tracking_info`
--
ALTER TABLE `tracking_info`
  ADD CONSTRAINT `FKsn5h6ojwrbt463ch00ifijkyv` FOREIGN KEY (`delivery_order_id`) REFERENCES `delivery_order` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
