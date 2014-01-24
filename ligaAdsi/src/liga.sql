-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-01-2014 a las 21:32:25
-- Versión del servidor: 5.6.11
-- Versión de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cdcol`
--
CREATE DATABASE IF NOT EXISTS `cdcol` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `cdcol`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cds`
--

CREATE TABLE IF NOT EXISTS `cds` (
  `titel` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `interpret` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `jahr` int(11) DEFAULT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `cds`
--

INSERT INTO `cds` (`titel`, `interpret`, `jahr`, `id`) VALUES
('Beauty', 'Ryuichi Sakamoto', 1990, 1),
('Goodbye Country (Hello Nightclub)', 'Groove Armada', 2001, 4),
('Glee', 'Bran Van 3000', 1997, 5);
--
-- Base de datos: `data`
--
CREATE DATABASE IF NOT EXISTS `data` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `data`;
--
-- Base de datos: `liga`
--
CREATE DATABASE IF NOT EXISTS `liga` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `liga`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arbitrostemporada`
--

CREATE TABLE IF NOT EXISTS `arbitrostemporada` (
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `NºColegiado` int(11) NOT NULL,
  PRIMARY KEY (`FechaInicio`,`FechaFin`,`NºColegiado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `NombreEquipo` varchar(20) NOT NULL,
  `Puntos` int(11) NOT NULL,
  `NombreEstadio` text NOT NULL,
  `NombreEntrenador` text NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  `FechaIni` date NOT NULL,
  `FechaFin` date NOT NULL,
  `NºJornada` int(11) NOT NULL,
  `Local` tinyint(1) NOT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`NombreEquipo`),
  KEY `Usuario` (`Usuario`,`FechaIni`,`FechaFin`,`NºJornada`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equiposparticipantes`
--

CREATE TABLE IF NOT EXISTS `equiposparticipantes` (
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `NombreEquipo` varchar(20) NOT NULL,
  PRIMARY KEY (`FechaInicio`,`FechaFin`,`NombreEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fechagol`
--

CREATE TABLE IF NOT EXISTS `fechagol` (
  `FechaInstante` datetime NOT NULL,
  `IDG` int(11) NOT NULL,
  PRIMARY KEY (`IDG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fechatarjeta`
--

CREATE TABLE IF NOT EXISTS `fechatarjeta` (
  `FechaInstante` datetime NOT NULL,
  `IDT` int(11) NOT NULL,
  PRIMARY KEY (`IDT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE IF NOT EXISTS `jornada` (
  `Finalizada` tinyint(1) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `NºJornada` int(11) NOT NULL,
  PRIMARY KEY (`Finalizada`,`FechaInicio`,`NºJornada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jornada`
--

INSERT INTO `jornada` (`Finalizada`, `FechaInicio`, `FechaFin`, `NºJornada`) VALUES
(0, '2014-01-31', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `Nombre` varchar(10) NOT NULL,
  `Dorsal` int(11) NOT NULL,
  `PartidosJugados` int(11) NOT NULL,
  `TarjetasRecibidas` int(11) NOT NULL,
  `Fichaje` tinyint(1) NOT NULL,
  `Expulsion` tinyint(1) NOT NULL,
  `DNI` int(11) NOT NULL,
  `NombreEquipo` varchar(20) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `NombreEquipo` (`NombreEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE IF NOT EXISTS `partido` (
  `NºGolesLocal` int(11) NOT NULL,
  `NºGolesVisitante` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `ID` int(11) NOT NULL,
  `FechaInicio` date NOT NULL,
  `FechaFin` date NOT NULL,
  `NºJornada` int(11) NOT NULL,
  `NºColegiado` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FechaInicio` (`FechaInicio`),
  KEY `FechaInicio_2` (`FechaInicio`,`FechaFin`,`NºJornada`,`NºColegiado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `partido`
--

INSERT INTO `partido` (`NºGolesLocal`, `NºGolesVisitante`, `Fecha`, `ID`, `FechaInicio`, `FechaFin`, `NºJornada`, `NºColegiado`) VALUES
(0, 0, '0000-00-00', 10, '0000-00-00', '0000-00-00', 1, 1597536824);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidogoljugador`
--

CREATE TABLE IF NOT EXISTS `partidogoljugador` (
  `IDG` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `DNI` int(11) NOT NULL,
  PRIMARY KEY (`IDG`,`ID`,`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidojugadortarjeta`
--

CREATE TABLE IF NOT EXISTS `partidojugadortarjeta` (
  `Tipo` varchar(10) NOT NULL,
  `IDT` int(11) NOT NULL,
  `DNI` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  PRIMARY KEY (`IDT`,`DNI`,`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sustitucionjugadorpartido`
--

CREATE TABLE IF NOT EXISTS `sustitucionjugadorpartido` (
  `DNIS` int(11) NOT NULL,
  `DNIE` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `FechaInstante` datetime NOT NULL,
  PRIMARY KEY (`DNIS`,`DNIE`,`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temporada`
--

CREATE TABLE IF NOT EXISTS `temporada` (
  `FechaIni` date NOT NULL,
  `FechaFin` date NOT NULL,
  PRIMARY KEY (`FechaIni`,`FechaFin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
-- Base de datos: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_bookmark`
--

CREATE TABLE IF NOT EXISTS `pma_bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_column_info`
--

CREATE TABLE IF NOT EXISTS `pma_column_info` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin' AUTO_INCREMENT=57 ;

--
-- Volcado de datos para la tabla `pma_column_info`
--

INSERT INTO `pma_column_info` (`id`, `db_name`, `table_name`, `column_name`, `comment`, `mimetype`, `transformation`, `transformation_options`) VALUES
(1, 'liga', 'Temporada', 'FechaIni', '', '', '_', ''),
(2, 'liga', 'Temporada', 'FechaFin', '', '', '_', ''),
(3, 'liga', 'Jornada', 'Finalizada', '', '', '_', ''),
(4, 'liga', 'Jornada', 'FechaInicio', '', '', '_', ''),
(5, 'liga', 'Jornada', 'FechaFin', '', '', '_', ''),
(6, 'liga', 'jornada', 'Finalizada', '', '', '_', ''),
(7, 'liga', 'jornada', 'FechaInicio', '', '', '_', ''),
(8, 'liga', 'jornada', 'FechaFin', '', '', '_', ''),
(9, 'liga', 'jornada', 'NºJornada', '', '', '_', ''),
(10, 'liga', 'Partido', 'NºGolesLocal', '', '', '_', ''),
(11, 'liga', 'Partido', 'NºGolesVisitante', '', '', '_', ''),
(12, 'liga', 'Partido', 'Fecha', '', '', '_', ''),
(13, 'liga', 'Partido', 'ID', '', '', '_', ''),
(14, 'liga', 'Partido', 'FechaInicio', '', '', '_', ''),
(15, 'liga', 'Partido', 'FechaFin', '', '', '_', ''),
(16, 'liga', 'Partido', 'NºJornada', '', '', '_', ''),
(17, 'liga', 'Partido', 'NºColegiado', '', '', '_', ''),
(18, 'liga', 'Equipo', 'NombreEquipo', '', '', '_', ''),
(19, 'liga', 'Equipo', 'Puntos', '', '', '_', ''),
(20, 'liga', 'Equipo', 'NombreEstadio', '', '', '_', ''),
(21, 'liga', 'Equipo', 'NombreEntrenador', '', '', '_', ''),
(22, 'liga', 'Equipo', 'Usuario', '', '', '_', ''),
(23, 'liga', 'Equipo', 'FechaIni', '', '', '_', ''),
(24, 'liga', 'Equipo', 'FechaFin', '', '', '_', ''),
(25, 'liga', 'Equipo', 'NºJornada', '', '', '_', ''),
(26, 'liga', 'Equipo', 'Local', '', '', '_', ''),
(27, 'liga', 'equipo', 'ID', '', '', '_', ''),
(28, 'liga', 'ArbitrosTemporada', 'FechaInicio', '', '', '_', ''),
(29, 'liga', 'ArbitrosTemporada', 'FechaFin', '', '', '_', ''),
(30, 'liga', 'ArbitrosTemporada', 'NºColegiado', '', '', '_', ''),
(31, 'liga', 'EquiposParticipantes', 'FechaInicio', '', '', '_', ''),
(32, 'liga', 'EquiposParticipantes', 'FechaFin', '', '', '_', ''),
(33, 'liga', 'EquiposParticipantes', 'NombreEquipo', '', '', '_', ''),
(34, 'liga', 'Jugador', 'Nombre', '', '', '_', ''),
(35, 'liga', 'Jugador', 'Dorsal', '', '', '_', ''),
(36, 'liga', 'Jugador', 'PartidosJugados', '', '', '_', ''),
(37, 'liga', 'Jugador', 'TarjetasRecibidas', '', '', '_', ''),
(38, 'liga', 'Jugador', 'Fichaje', '', '', '_', ''),
(39, 'liga', 'Jugador', 'Expulsion', '', '', '_', ''),
(40, 'liga', 'Jugador', 'DNI', '', '', '_', ''),
(41, 'liga', 'Jugador', 'NombreEquipo', '', '', '_', ''),
(42, 'liga', 'FechaTarjeta', 'FechaInstante', '', '', '_', ''),
(43, 'liga', 'FechaTarjeta', 'IDT', '', '', '_', ''),
(44, 'liga', 'FechaGol', 'FechaInstante', '', '', '_', ''),
(45, 'liga', 'FechaGol', 'IDG', '', '', '_', ''),
(46, 'liga', 'PartidoGolJugador', 'IDG', '', '', '_', ''),
(47, 'liga', 'PartidoGolJugador', 'ID', '', '', '_', ''),
(48, 'liga', 'PartidoGolJugador', 'DNI', '', '', '_', ''),
(49, 'liga', 'PartidoJugadorTarjeta', 'Tipo', '', '', '_', ''),
(50, 'liga', 'PartidoJugadorTarjeta', 'IDT', '', '', '_', ''),
(51, 'liga', 'PartidoJugadorTarjeta', 'DNI', '', '', '_', ''),
(52, 'liga', 'PartidoJugadorTarjeta', 'ID', '', '', '_', ''),
(53, 'liga', 'SustitucionJugadorPartido', 'DNIS', '', '', '_', ''),
(54, 'liga', 'SustitucionJugadorPartido', 'DNIE', '', '', '_', ''),
(55, 'liga', 'SustitucionJugadorPartido', 'ID', '', '', '_', ''),
(56, 'liga', 'SustitucionJugadorPartido', 'FechaInstante', '', '', '_', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_designer_coords`
--

CREATE TABLE IF NOT EXISTS `pma_designer_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `v` tinyint(4) DEFAULT NULL,
  `h` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for Designer';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_history`
--

CREATE TABLE IF NOT EXISTS `pma_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`db`,`table`,`timevalue`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_pdf_pages`
--

CREATE TABLE IF NOT EXISTS `pma_pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  PRIMARY KEY (`page_nr`),
  KEY `db_name` (`db_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_recent`
--

CREATE TABLE IF NOT EXISTS `pma_recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Volcado de datos para la tabla `pma_recent`
--

INSERT INTO `pma_recent` (`username`, `tables`) VALUES
('root', '[{"db":"liga","table":"jornada"},{"db":"liga","table":"partido"},{"db":"liga","table":"temporada"},{"db":"liga","table":"SustitucionJugadorPartido"},{"db":"liga","table":"PartidoJugadorTarjeta"},{"db":"liga","table":"PartidoGolJugador"},{"db":"liga","table":"FechaGol"},{"db":"liga","table":"FechaTarjeta"},{"db":"liga","table":"Jugador"},{"db":"liga","table":"EquiposParticipantes"}]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_relation`
--

CREATE TABLE IF NOT EXISTS `pma_relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  KEY `foreign_field` (`foreign_db`,`foreign_table`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_table_coords`
--

CREATE TABLE IF NOT EXISTS `pma_table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float unsigned NOT NULL DEFAULT '0',
  `y` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_table_info`
--

CREATE TABLE IF NOT EXISTS `pma_table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_table_uiprefs`
--

CREATE TABLE IF NOT EXISTS `pma_table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`,`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_tracking`
--

CREATE TABLE IF NOT EXISTS `pma_tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) unsigned NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`db_name`,`table_name`,`version`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_userconfig`
--

CREATE TABLE IF NOT EXISTS `pma_userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Volcado de datos para la tabla `pma_userconfig`
--

INSERT INTO `pma_userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2013-11-25 17:21:43', '{"lang":"es"}');
--
-- Base de datos: `seguridad`
--
CREATE DATABASE IF NOT EXISTS `seguridad` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `seguridad`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercado`
--

CREATE TABLE IF NOT EXISTS `mercado` (
  `codigo` int(5) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(1000) COLLATE utf8_spanish_ci NOT NULL,
  `usuario` int(3) NOT NULL,
  `ruta_imagen` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FOREIGN` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `mercado`
--

INSERT INTO `mercado` (`codigo`, `titulo`, `descripcion`, `usuario`, `ruta_imagen`, `fecha`) VALUES
(5, 'Prueba 1', 'Prueba 1, prueba 1, prueba 1.', 1, '', '2013-12-08 16:47:28'),
(6, 'Prueba 2', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:10'),
(7, 'Prueba 3', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:15'),
(8, 'Prueba 4', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:19'),
(9, 'Prueba 5', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:22'),
(10, 'Prueba 6', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:26'),
(11, 'Prueba 7', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:29'),
(12, 'Prueba 8', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:34'),
(13, 'Prueba 9', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:38'),
(14, 'Prueba 10', 'Prueba, prueba, prueba.', 1, '', '2013-12-10 15:56:41'),
(15, 'Prueba 11', 'Prueba 11, prueba, prueba.', 1, '', '2013-12-10 16:01:38'),
(16, 'Prueba 12', 'Prueba 12, prueba, prueba.', 1, '', '2013-12-10 16:28:51'),
(17, 'Prueba 69', 'Esta es la prueba numero 69.', 1, NULL, '2013-12-11 10:21:29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `codigo` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(9) NOT NULL,
  `contrasena` char(128) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` tinyint(1) NOT NULL DEFAULT '0',
  `sal` char(128) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=21 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codigo`, `nombre`, `correo`, `telefono`, `contrasena`, `tipo`, `sal`) VALUES
(1, 'admin', 'admin@seguridad.com', 696969696, '5ea0bd5786c93e164ac251c61d62d3e54abe5d58dabd9017af2edfd86959d9a84856555cb4e22d4b3ce336e5d39a8051160a2ebe077d33bb7db07a76a880480c', 1, '4d6576043a66aeb91f22c829d80a0bc0bc8336b28d23bc3007aa9b1f93b37169c3f1c9fa5d26aa58af7385ef3de8bdf8304eaef9b4af6ba4bd63e66804de3c47'),
(17, 'mag', 'mag@num.com', 650230120, 'd491064bbff34da9fb309d88d6174432b28f843f3ad9ccde41a20c3773421b82ef42cb17e74a362c444464aeb0414812c2eeaf11a0dc0bf3dee8ee4c0f6b23c7', 0, '914b5d4264b49f0381e800f463f1e86c2dedee5cccb62e23b5c945073ec3f5eef032df8724bd39f7797c44c17b1ae18f273d47390e9b009809869f89c549b7f3'),
(18, 'asdf', 'adg@num.com', 622222222, '5f6c12c9f9bb8522aa9658b13aea68761493c7352832a473e080c47701982c6fefe0504cf0fd8b1b99e6708f1ae14d0920527ac5d9563b74ceb5c4260ac1b832', 0, '0a0803e8acf9477d5bd2acbbf666977025b524fb16c019b96e37ecc0f8776aeb0796ef2cf6368034a74cd91ec0a307bfc23ff5af706add02e61d26067602ce29'),
(19, 'qwerty', 'qwe@rty.com', 654200002, '8f0135eed932137dde14d1b43826cafe7ce88a01652e10ef67c612376b62422af799adf8e4d4bf5be5a707387e744969fbe1fe69d430df88d363d14a689c54c9', 0, 'd02331f621e8843c2a4fa064564287a81c05805cf944a9b1ad406f955183cf7cbbf86f33d0f79f2c47358d611eabe2b07dcec11ab1a22b181604c1a6adc875ec'),
(20, 'pipolibo', 'pipo.libo@gmail.com', 696969696, '0e5bb274263e595676d2eb655d08386d9c599ce2378b8cc160ecdb6556f7d09dd7651edeeec90e148411cf74026bcbf53369ed695283cb4ece9107db5bc5201f', 0, '065e1c1909964c7d29bf582b86754ce7bb6b6e9429aa4cee0a1406691c1fe7e705db6e0080ba682e43c8fc8da16ad12a126471246bfe66781063f512197216ef');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `mercado`
--
ALTER TABLE `mercado`
  ADD CONSTRAINT `mercado_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de datos: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_multi_sets`()
    DETERMINISTIC
begin
        select user() as first_col;
        select user() as first_col, now() as second_col;
        select user() as first_col, now() as second_col, now() as third_col;
        end$$

DELIMITER ;
--
-- Base de datos: `webauth`
--
CREATE DATABASE IF NOT EXISTS `webauth` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `webauth`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_pwd`
--

CREATE TABLE IF NOT EXISTS `user_pwd` (
  `name` char(30) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `pass` char(32) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `user_pwd`
--

INSERT INTO `user_pwd` (`name`, `pass`) VALUES
('xampp', 'wampp');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
