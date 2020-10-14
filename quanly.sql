-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 14, 2020 lúc 04:18 AM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanly`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GENDER` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PHONE` int(11) NOT NULL,
  `EMAIL` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `CLASS` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MAJOR` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SCORE` double UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ID`, `NAME`, `GENDER`, `PHONE`, `EMAIL`, `CLASS`, `MAJOR`, `SCORE`) VALUES
(1, 'Tuấn', 'Nam', 384727271, 'tuan@gmail.com', 'C0720i2', 'PHP', 6.5),
(2, 'Thu', 'Nữ', 239101311, 'thu@gmail.com', 'C0720i1', 'Java', 6),
(4, 'Khánh', 'Nam', 123123333, 'khanh@gmail.com', 'C0720i1', 'Java', 4),
(5, 'Tiến', 'Nam', 123456789, 'tien@gmail.com', 'C0720i2', 'Java', 8),
(6, 'Huỳnh', 'Nam', 123456789, 'huynh@gmail.com', 'C0520h1', 'PHP', 2.5),
(7, 'Tuấn Anh', 'Nam', 123456789, 'tuan.anh@gmail.com', 'C0720i2', 'Java', 7),
(8, 'Huỳnh', 'Nam', 123456789, 'huynh@gmail.com', 'C0720i1', 'Java', 10),
(35, 'Quân', 'Nam', 123123222, 'tuan.anh@gmail.com', 'C0720i1', 'Java', 4);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
