delete from PeliculaEntity_PersonaEntity;
delete from PERSONAENTITY_ABONOENTITY;
DELETE FROM FESTIVALENTITY_PELICULAENTITY;
DELETE FROM FESTIVALENTITY_PERSONAENTITY;
DELETE FROM FUNCIONENTITY_BOLETAENTITY;
DELETE FROM FUNCIONENTITY_CRITICAENTITY;
DELETE FROM PELICULAENTITY_PERSONAENTITY;
DELETE FROM PERSONAENTITY_BOLETAENTITY;
DELETE FROM PERSONAENTITY_CRITICAENTITY;
delete from salaentity_funcionentity;
delete from CriticaEntity;
delete from BoletaEntity;
delete from CalificacionEntity;
delete from FuncionEntity;
delete from SillaEntity;
delete from AbonoEntity;
delete from PersonaEntity;
delete from FuncionEntity;
delete from SalaEntity;
delete from PeliculaEntity;
delete from TeatroEntity;
delete from FestivalEntity;

/* FestivalEnity*/

    insert into FestivalEntity(id, name, fechaInicio, fechaFin) values (1, 'verano', '8/20/2017','8/23/2017' );
    insert into FestivalEntity(id, name, fechaInicio, fechaFin) values (2, 'invierno', '8/24/2017','9/7/2017' );
    insert into FestivalEntity(id, name, fechaInicio, fechaFin) values (3, 'primavera', '9/8/2017','9/23/2017' );
    insert into FestivalEntity(id, name, fechaInicio, fechaFin) values (4, 'otonio', '9/24/2017','10/7/2017' );
/* TeatroEntity */

    insert into TeatroEntity(id, name, tarifaBasica) values (1, 'colombia', 8000);
    insert into TeatroEntity(id, name, tarifaBasica) values (2, 'chapinero', 7000);
    insert into TeatroEntity(id, name, tarifaBasica) values (3, 'colon', 7500);
    insert into TeatroEntity(id, name, tarifaBasica) values (4, 'catellana', 8500);
    insert into TeatroEntity(id, name, tarifaBasica) values (5, 'country', 9000);
    insert into TeatroEntity(id, name, tarifaBasica) values (6, 'occidental', 8500);
    insert into TeatroEntity(id, name, tarifaBasica) values (7, 'central' ,7500);
    insert into TeatroEntity(id, name, tarifaBasica) values (8, 'oriental', 7500);
    insert into TeatroEntity(id, name, tarifaBasica) values (9, 'norte',9000);
    insert into TeatroEntity(id, name, tarifaBasica) values (10, 'sur' ,8600);
/* SalaEntity */   

    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (1, 's1', 40, 10, 1);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (2, 's2', 40, 10, 2);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (3, 's3', 40, 10, 3);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (4, 's4', 40, 10, 4);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (5, 's5', 40, 10, 5);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (6, 's6', 40, 10, 6);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (7, 's7', 40, 10, 7);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (8, 's8', 40, 10, 8);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (9, 's9', 40, 10, 9);
    insert into SalaEntity (id, name, numSillas, numSillasPreferenciales, teatro_id) values (10, 's10', 40, 10, 10);

/* SillaEntity */

    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (71.92, 0, 1);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (97.06, 0, 1);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (64.79, 1, 1);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (39.03, 1, 2);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (23.65, 0, 2);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (75.07, 1, 2);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (43.11, 1, 3);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (88.15, 1, 3);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (39.94, 0, 3);
    insert into SillaEntity (tarifa, esPreferencial, sala_id) values (59.54, 1, 3);

    delete from SillaEntity;

    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1, 71.92, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (2, 97.06, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (3, 64.79, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (4, 39.03, 1, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (5, 23.65, 0, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (6, 75.07, 1, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (7, 43.11, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (8, 88.15, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (9, 39.94, 0, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (10,59.54, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1001, 78.35, 1, 4);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1002, 177.55, 1, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1003, 78.9, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1004, 39.98, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1005, 18.55, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1006, 120.88, 0, 7);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1007, 69.54, 1, 4);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1008, 19.31, 1, 7);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1009, 23.38, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1010, 101.36, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1011, 12.74, 1, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1012, 62.91, 1, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1013, 150.78, 1, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1014, 65.25, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1015, 89.45, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1016, 45.55, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1017, 19.16, 0, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1018, 156.13, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1019, 189.31, 0, 7);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1020, 19.72, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1021, 176.53, 1, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1022, 119.25, 0, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1023, 142.21, 0, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1024, 48.78, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1025, 186.94, 1, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1026, 14.28, 1, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1027, 22.29, 0, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1028, 74.75, 0, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1029, 100.77, 0, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1030, 68.68, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1031, 93.5, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1032, 163.09, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1033, 193.16, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1034, 65.26, 0, 4);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1035, 18.14, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1036, 63.08, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1037, 59.82, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1038, 142.48, 0, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1039, 138.7, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1040, 26.43, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1041, 144.51, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1042, 155.82, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1043, 10.44, 0, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1044, 124.44, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1045, 57.91, 1, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1046, 158.72, 0, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1047, 16.46, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1048, 35.95, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1049, 77.46, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1050, 90.57, 0, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1051, 42.49, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1052, 127.52, 0, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1053, 24.71, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1054, 27.14, 1, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1055, 44.47, 1, 4);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1056, 57.25, 0, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1057, 105.73, 1, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1058, 52.05, 0, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1059, 137.47, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1060, 12.03, 1, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1061, 60.65, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1062, 36.41, 0, 7);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1063, 85.57, 1, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1064, 90.89, 0, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1065, 157.96, 0, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1066, 132.67, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1067, 36.85, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1068, 181.05, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1069, 34.24, 1, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1070, 75.58, 1, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1071, 120.99, 1, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1072, 55.27, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1073, 107.01, 1, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1074, 156.44, 0, 1);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1075, 155.81, 1, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1076, 117.61, 0, 2);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1077, 109.44, 0, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1078, 162.15, 0, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1079, 174.84, 1, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1080, 159.93, 1, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1081, 97.34, 0, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1082, 87.3, 0, 7);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1083, 19.31, 0, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1084, 179.08, 0, 3);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1085, 133.3, 0, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1086, 102.3, 0, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1087, 120.18, 0, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1088, 146.06, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1089, 186.06, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1090, 164.59, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1091, 176.75, 0, 6);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1092, 65.7, 1, 10);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1093, 15.89, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1094, 54.34, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1095, 175.79, 1, 5);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1096, 197.02, 1, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1097, 144.82, 0, 7);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1098, 73.18, 1, 9);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1099, 76.62, 0, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1100, 93.57, 1, 8);
    insert into SillaEntity (id, tarifa, esPreferencial, sala_id) values (1101, 128.55, 1, 8);


delete from PeliculaEntity;
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director, sinopsis) values (1001, 'Batman', 'https://images-na.ssl-images-amazon.com/images/I/61sGxnXeqiL._SY550_.jpg', 33656, 'Drama|Thriller', 'Russia', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Hillie Whyman', 'a');
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director, sinopsis) values (1002, 'Tarzan', 'https://images-na.ssl-images-amazon.com/images/I/71ievnadZXL.SL1014.jpg', 3769, 'Action|Crime|Thriller', 'Hungary', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Rodrique Kaines', 'a');
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director, sinopsis) values (1003, 'Nemo', 'https://www.sonuit.fr/532/poster-mural-le-monde-de-nemo-panoramique-disney-komar.jpg', 749, 'Crime', 'Indonesia', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Liana Illsley', 'a');
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director, sinopsis) values (1004, 'Coraline', 'http://s3.media.squarespace.com/production/465215/5307878/wp-content/uploads/2008/12/coraline1_large.jpg', 2589, 'Crime|Drama|Mystery|Thriller|War', 'Canada', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Devonne Beeston', 'a');
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director, sinopsis) values (1005, 'As above so Below', 'https://klling.files.wordpress.com/2017/07/as-above-so-below.jpg', 2880, 'Drama', 'Indonesia', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Maudie Brandreth', 'a');


/* FuncionEntity */
  
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (1, 'Katalin Varga', '4/17/2017', '9/23/2016',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (2, 'Double Hour, The (La doppia ora)', '12/16/2016', '10/12/2016',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (3, 'Changeling, The', '11/27/2016', '5/4/2017',3,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (4, 'Recollections of the Yellow House (Recordações da Casa Amarela)', '12/28/2016', '7/27/2017',4,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (5, 'Lt. Robin Crusoe, U.S.N.', '1/9/2017', '11/21/2016',5,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (6, 'Zorro', '7/10/2017', '2/25/2017',6,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (7, 'Little Lili (La petite Lili)', '4/7/2017', '4/17/2017',7,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (8, 'Keeping the Promise (Sign of the Beaver, The)', '12/15/2016', '3/23/2017',8,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (9, 'Holokaustin värit', '3/2/2017', '7/13/2017',9,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (10, 'Panic Room', '10/18/2016', '12/28/2016',10,1,1001);

/* SalaEntity_FuncionEntity*/
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(1,1);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(1,2);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(3,3);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(4,4);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(5,5);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(6,6);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(7,7);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(8,8);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(9,9);
insert into SalaEntity_FuncionEntity(SalaEntity_ID,Funciones_ID) values(10,10);
/* CriticoEntity */

    insert into PersonaEntity (id, name, dtype) values (1001, 'Inger Danielou', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1002, 'Muhammad Kerby', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1003, 'Poul Joselevitch', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1004, 'Chiarra Golland', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1005, 'Neile Beckhouse', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1006, 'Theresita Pickin', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1007, 'Flory Duggen', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1008, 'Rudie Aronsohn', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1009, 'Cash Matiasek', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1010, 'Carmine Pessel', 'CriticoEntity');
 


    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1011, 'Patsy Poytres', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1012, 'Muire Cassius', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1013, 'Collen Zorzoni', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1014, 'Sophie Deschelle', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1015, 'Curtice Gasker', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1016, 'Netti Mallinar', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1017, 'Edik Chesney', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1018, 'Lida Roulston', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1019, 'Deana Westney', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1020, 'Lorry Bagby', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1021, 'Christi Andren', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1022, 'Earl Eva', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1023, 'Goraud Grinham', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1024, 'Iver Frith', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1025, 'Barn Gilhoolie', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1026, 'Manfred Summers', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1027, 'Mirna Harle', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1028, 'Adiana Gyenes', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1029, 'Dannie Cusick', 'EspectadorEntity');
    insert into PERSONAENTITY (ID, NAME, DTYPE) values (1030, 'Cassaundra Berney', 'EspectadorEntity');

/*PatrocinadorEntity*/

    insert into PersonaEntity (id, NIT, patrocinio, name, dtype) values (1040, 1010, 200000, 'Ministerio de cultura', 'PatrocinadorEntity');
    insert into PersonaEntity (id, NIT, patrocinio, name, dtype) values (1042, 1020, 200000, 'Alcaldía mayor de Bogotá', 'PatrocinadorEntity');
    insert into PersonaEntity (id, NIT, patrocinio, name, dtype) values (1041, 1030, 200000, 'Secretaría de cultura, recreación y deporte', 'PatrocinadorEntity');
    insert into PersonaEntity (id, NIT, patrocinio, name, dtype) values (1043, 1040, 200000, 'Fundación procultura', 'PatrocinadorEntity');
    insert into PersonaEntity (id, NIT, patrocinio, name, dtype) values (1044, 1050, 200000, 'Asociación colombiana de cine', 'PatrocinadorEntity');
    insert into PersonaEntity (id, NIT, patrocinio, name, dtype) values (1045, 1060, 200000, 'Academia colombiana de producción cinematográfica', 'PatrocinadorEntity');

/*PeliculaEntity - PersonaEntity */

    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1001, 1001);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1002, 1002);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1003, 1003);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1004, 1004);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1005, 1005);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1004, 1006);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1002, 1007);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1001, 1008);

/* CriticaEntity */

    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);
    insert into CriticaEntity (critico_id, funcion_id) values (1001,1);

    delete from CriticaEntity;

    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (1, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.

    Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

    Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1001, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (2, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.

    In congue. Etiam justo. Etiam pretium iaculis justo.

    In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 1001, 2);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (3, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.', 1002, 3);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (4, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.

    Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

    Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 1001, 4);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (5, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.

    Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

    Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 1003, 5);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (6, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.

    Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.', 1002, 6);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (7, 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

    Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1001, 7);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (8, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.

    Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 1004, 8);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (9, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.

    Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.


    Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus ', 1001, 9);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (10, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 1005, 10);

/* boletas de Espectador*/

    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1011, 10);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1012, 20);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1013, 30);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1014, 40);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1015, 50);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1015, 60);

/* CalificacionEntity */

    insert into CalificacionEntity (id,calificacion, comentario) values(100,1.1,'a1');
    insert into CalificacionEntity (id,calificacion, comentario) values(101,2.2,'a2');
    insert into CalificacionEntity (id,calificacion, comentario) values(102,3.3,'a3');
    insert into CalificacionEntity (id,calificacion, comentario) values(103,4.4,'a4');
    insert into calificacionEntity (id, calificacion, comentario) values (104, 3.3, 'et magnis dis');
    insert into calificacionEntity (id, calificacion, comentario) values (105, 2.2, 'duis faucibus accumsan odio curabitur convallis duis consequat dui nec');
    insert into calificacionEntity (id, calificacion, comentario) values (106, 2.0, 'nulla eget eros elementum pellentesque quisque porta volutpat erat');
    insert into calificacionEntity (id, calificacion, comentario) values (107, 4.3, 'eleifend quam');
    insert into calificacionEntity (id, calificacion, comentario) values (108, 4.3, 'integer tincidunt ante vel ipsum praesent');
    insert into calificacionEntity (id, calificacion, comentario) values (109, 2.3, 'curae duis faucibus');
    insert into calificacionEntity (id, calificacion, comentario) values (110, 4.8, 'duis at');
    insert into calificacionEntity (id, calificacion, comentario) values (111, 3.2, 'diam id ornare imperdiet sapien');
    insert into calificacionEntity (id, calificacion, comentario) values (112, 3.3, 'congue etiam justo etiam');
    insert into calificacionEntity (id, calificacion, comentario) values (113, 2.3, 'mauris eget massa tempor convallis nulla');
    insert into calificacionEntity (id, calificacion, comentario) values (114, 3.1, 'nullam porttitor lacus at turpis donec posuere');
    insert into calificacionEntity (id, calificacion, comentario) values (115, 2.9, 'rutrum neque aenean auctor gravida');
    insert into calificacionEntity (id, calificacion, comentario) values (116, 2.1, 'ipsum integer a nibh in quis justo maecenas rhoncus');
    insert into calificacionEntity (id, calificacion, comentario) values (117, 2.9, 'rhoncus sed vestibulum sit amet cursus id turpis');
    insert into calificacionEntity (id, calificacion, comentario) values (118, 1.1, 'platea dictumst aliquam augue');
    insert into calificacionEntity (id, calificacion, comentario) values (119, 4.2, 'rhoncus mauris enim leo');
    insert into calificacionEntity (id, calificacion, comentario) values (120, 4.5, 'duis at velit');
    insert into calificacionEntity (id, calificacion, comentario) values (121, 2.2, 'mauris viverra diam vitae quam suspendisse');
    insert into calificacionEntity (id, calificacion, comentario) values (122, 1.6, 'mollis molestie lorem quisque ut');
    insert into calificacionEntity (id, calificacion, comentario) values (123, 3.4, 'felis ut at dolor');
    insert into calificacionEntity (id, calificacion, comentario) values (124, 5.0, 'ac nibh');
    insert into calificacionEntity (id, calificacion, comentario) values (125, 2.0, 'ante vivamus tortor duis');
    insert into calificacionEntity (id, calificacion, comentario) values (126, 3.0, 'non mauris morbi non lectus');
    insert into calificacionEntity (id, calificacion, comentario) values (127, 1.8, 'ipsum primis in faucibus');
    insert into calificacionEntity (id, calificacion, comentario) values (128, 3.2, 'porttitor lacus at turpis donec posuere');
    insert into calificacionEntity (id, calificacion, comentario) values (129, 3.0, 'ligula nec sem duis aliquam convallis');
    insert into calificacionEntity (id, calificacion, comentario) values (130, 4.0, 'integer non velit');
    insert into calificacionEntity (id, calificacion, comentario) values (131, 4.3, 'pretium iaculis justo');
    insert into calificacionEntity (id, calificacion, comentario) values (132, 1.3, 'adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus');
    insert into calificacionEntity (id, calificacion, comentario) values (133, 2.0, 'cras pellentesque volutpat');
    insert into calificacionEntity (id, calificacion, comentario) values (134, 1.8, 'magna ac consequat metus sapien');
    insert into calificacionEntity (id, calificacion, comentario) values (135, 3.3, 'praesent id massa id');
    insert into calificacionEntity (id, calificacion, comentario) values (136, 4.1, 'id mauris vulputate');
    insert into calificacionEntity (id, calificacion, comentario) values (137, 1.1, 'orci nullam molestie nibh in lectus pellentesque at nulla');
    insert into calificacionEntity (id, calificacion, comentario) values (138, 2.1, 'maecenas leo odio condimentum id luctus nec molestie');
    insert into calificacionEntity (id, calificacion, comentario) values (139, 4.9, 'phasellus id sapien in');
    insert into calificacionEntity (id, calificacion, comentario) values (140, 3.6, 'curae donec pharetra');
    insert into calificacionEntity (id, calificacion, comentario) values (141, 4.5, 'sagittis sapien cum sociis natoque penatibus');
    insert into calificacionEntity (id, calificacion, comentario) values (142, 3.9, 'non mi integer');
    insert into calificacionEntity (id, calificacion, comentario) values (143, 1.2, 'dictumst morbi vestibulum velit id');
    insert into calificacionEntity (id, calificacion, comentario) values (144, 3.4, 'sapien ut nunc vestibulum');
    insert into calificacionEntity (id, calificacion, comentario) values (145, 4.1, 'erat id mauris');
    insert into calificacionEntity (id, calificacion, comentario) values (146, 3.3, 'ut erat id mauris vulputate elementum nullam varius nulla facilisi');
    insert into calificacionEntity (id, calificacion, comentario) values (147, 2.7, 'rutrum ac lobortis vel');
    insert into calificacionEntity (id, calificacion, comentario) values (148, 1.2, 'praesent blandit lacinia erat vestibulum sed magna at nunc commodo');
    insert into calificacionEntity (id, calificacion, comentario) values (149, 3.1, 'vulputate nonummy maecenas tincidunt');
    insert into calificacionEntity (id, calificacion, comentario) values (150, 1.4, 'et magnis dis parturient montes');
    insert into calificacionEntity (id, calificacion, comentario) values (151, 2.6, 'magna bibendum imperdiet nullam orci pede venenatis');
    insert into calificacionEntity (id, calificacion, comentario) values (152, 1.6, 'sapien urna');
    insert into calificacionEntity (id, calificacion, comentario) values (153, 2.4, 'ut mauris eget massa tempor convallis nulla neque libero convallis');
    insert into calificacionEntity (id, calificacion, comentario) values (154, 1.3, 'sit amet consectetuer adipiscing elit');
    insert into calificacionEntity (id, calificacion, comentario) values (155, 3.5, 'platea dictumst');
    insert into calificacionEntity (id, calificacion, comentario) values (156, 4.6, 'quisque porta volutpat');
    insert into calificacionEntity (id, calificacion, comentario) values (157, 1.8, 'accumsan tortor quis');
    insert into calificacionEntity (id, calificacion, comentario) values (158, 3.1, 'mi in porttitor');
    insert into calificacionEntity (id, calificacion, comentario) values (159, 1.6, 'lorem ipsum dolor');
    insert into calificacionEntity (id, calificacion, comentario) values (160, 4.9, 'gravida sem praesent id massa id nisl venenatis lacinia');
    insert into calificacionEntity (id, calificacion, comentario) values (161, 4.7, 'vestibulum ac');
    insert into calificacionEntity (id, calificacion, comentario) values (162, 3.4, 'at turpis a pede posuere');
    insert into calificacionEntity (id, calificacion, comentario) values (163, 4.3, 'vel nulla eget');
    insert into calificacionEntity (id, calificacion, comentario) values (164, 3.7, 'ultrices posuere cubilia curae donec');
    insert into calificacionEntity (id, calificacion, comentario) values (165, 1.1, 'et eros');
    insert into calificacionEntity (id, calificacion, comentario) values (166, 2.3, 'non lectus');
    insert into calificacionEntity (id, calificacion, comentario) values (167, 4.2, 'sit amet');
    insert into calificacionEntity (id, calificacion, comentario) values (168, 3.9, 'lobortis ligula sit');
    insert into calificacionEntity (id, calificacion, comentario) values (169, 4.4, 'at velit eu est congue elementum in');
    insert into calificacionEntity (id, calificacion, comentario) values (170, 2.6, 'quis augue luctus');
    insert into calificacionEntity (id, calificacion, comentario) values (171, 4.1, 'rhoncus sed vestibulum sit');
    insert into calificacionEntity (id, calificacion, comentario) values (172, 1.8, 'varius ut');
    insert into calificacionEntity (id, calificacion, comentario) values (173, 2.6, 'dui maecenas tristique');
    insert into calificacionEntity (id, calificacion, comentario) values (174, 4.2, 'cras pellentesque volutpat dui maecenas');
    insert into calificacionEntity (id, calificacion, comentario) values (175, 4.3, 'quam nec dui');
    insert into calificacionEntity (id, calificacion, comentario) values (176, 1.9, 'curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin');
    insert into calificacionEntity (id, calificacion, comentario) values (177, 2.0, 'pede lobortis ligula sit amet eleifend pede libero');
    insert into calificacionEntity (id, calificacion, comentario) values (178, 2.5, 'interdum mauris ullamcorper purus sit amet');
    insert into calificacionEntity (id, calificacion, comentario) values (179, 3.9, 'tincidunt eget');
    insert into calificacionEntity (id, calificacion, comentario) values (180, 4.2, 'donec vitae nisi nam ultrices libero non mattis pulvinar nulla');
    insert into calificacionEntity (id, calificacion, comentario) values (181, 2.6, 'etiam justo etiam pretium iaculis justo in hac habitasse');
    insert into calificacionEntity (id, calificacion, comentario) values (182, 2.6, 'aliquet at feugiat non');
    insert into calificacionEntity (id, calificacion, comentario) values (183, 3.6, 'sapien ut nunc vestibulum ante ipsum');
    insert into calificacionEntity (id, calificacion, comentario) values (184, 3.1, 'in sagittis dui vel nisl duis ac');
    insert into calificacionEntity (id, calificacion, comentario) values (185, 4.4, 'fusce congue diam id');
    insert into calificacionEntity (id, calificacion, comentario) values (186, 3.6, 'lacinia eget tincidunt eget tempus vel pede morbi porttitor');
    insert into calificacionEntity (id, calificacion, comentario) values (187, 2.4, 'tempus sit amet sem fusce consequat nulla');
    insert into calificacionEntity (id, calificacion, comentario) values (188, 4.3, 'varius integer ac leo pellentesque');
    insert into calificacionEntity (id, calificacion, comentario) values (189, 2.4, 'est quam pharetra magna ac consequat metus sapien ut');
    insert into calificacionEntity (id, calificacion, comentario) values (190, 1.8, 'rhoncus sed vestibulum sit amet');
    insert into calificacionEntity (id, calificacion, comentario) values (191, 2.1, 'tempor convallis nulla neque');
    insert into calificacionEntity (id, calificacion, comentario) values (192, 2.2, 'sit amet');
    insert into calificacionEntity (id, calificacion, comentario) values (193, 1.7, 'fermentum donec ut');
    insert into calificacionEntity (id, calificacion, comentario) values (194, 3.3, 'nisi vulputate nonummy maecenas tincidunt lacus at velit');
    insert into calificacionEntity (id, calificacion, comentario) values (195, 4.2, 'duis consequat dui nec nisi volutpat eleifend donec ut dolor');
    insert into calificacionEntity (id, calificacion, comentario) values (196, 3.6, 'aenean auctor gravida sem praesent');
    insert into calificacionEntity (id, calificacion, comentario) values (197, 3.7, 'nunc donec quis orci eget orci vehicula');
    insert into calificacionEntity (id, calificacion, comentario) values (198, 3.4, 'ridiculus mus vivamus');
    insert into calificacionEntity (id, calificacion, comentario) values (199, 2.6, 'vivamus vel nulla eget eros elementum');
    insert into calificacionEntity (id, calificacion, comentario) values (200, 2.0, 'porttitor lorem id ligula suspendisse ornare consequat lectus');
    insert into calificacionEntity (id, calificacion, comentario) values (201, 1.5, 'blandit ultrices');
    insert into calificacionEntity (id, calificacion, comentario) values (202, 3.6, 'aliquam sit amet diam in magna bibendum imperdiet nullam');
    insert into calificacionEntity (id, calificacion, comentario) values (203, 4.7, 'ridiculus mus vivamus vestibulum sagittis sapien');


/* BoletaEntity*/

    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(10, 120, 1, 500.50, 1, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(20, 130, 2, 600.50, 2, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(30, 110, 1, 700.50, 3, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(40, 50, 3, 400.50, 4, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id) values(50, 500, 3, 400.50, 5, 2, 1011);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values(60, 650, 3, 300.25, 2, 3, 1012, 100);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (70, 8981, 3, 311.82, 1001, 7, 1027, 194);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (80, 8221, 3, 526.73, 1002, 4, 1030, 188);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (90, 7244, 3, 823.04, 1003, 8, 1013, 165);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (100, 9277, 3, 989.34, 1004, 1, 1015, 157);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (110, 4932, 3, 102.93, 1005, 6, 1027, 189);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (120, 5265, 3, 560.14, 1006, 5, 1026, 156);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (130, 2698, 3, 496.29, 1007, 8, 1019, 172);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (140, 4689, 3, 305.15, 1008, 9, 1026, 107);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (150, 2355, 3, 593.6, 1009, 1, 1012, 109);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (160, 9908, 3, 954.9, 1010, 9, 1023, 124);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (170, 4055, 3, 207.25, 1011, 5, 1024, 135);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (180, 1716, 3, 301.59, 1012, 9, 1024, 115);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (190, 9252, 3, 783.12, 1013, 1, 1026, 106);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (200, 2363, 3, 453.38, 1014, 7, 1023, 139);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (210, 6811, 3, 304.8, 1015, 1, 1015, 152);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (220, 4523, 3, 141.09, 1016, 8, 1022, 200);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (230, 6109, 3, 177.99, 1017, 2, 1022, 179);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (240, 9285, 3, 437.88, 1018, 2, 1015, 122);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (250, 8071, 3, 512.11, 1019, 3, 1023, 197);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (260, 9724, 3, 525.24, 1020, 8, 1012, 185);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (270, 8777, 3, 918.51, 1021, 1, 1030, 188);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (280, 4003, 3, 186.59, 1022, 5, 1014, 132);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (290, 3914, 3, 887.69, 1023, 1, 1016, 148);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (300, 6037, 3, 163.25, 1024, 8, 1012, 152);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (310, 6945, 3, 329.49, 1025, 5, 1022, 162);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (320, 7475, 3, 468.42, 1026, 4, 1020, 116);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (330, 4400, 3, 201.84, 1027, 1, 1027, 182);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (340, 3000, 3, 128.18, 1028, 5, 1017, 141);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (350, 4177, 3, 604.64, 1029, 1, 1026, 144);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (360, 5572, 3, 571.42, 1030, 5, 1014, 105);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (370, 1236, 3, 562.19, 1031, 4, 1021, 187);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (380, 4927, 3, 192.84, 1032, 2, 1015, 176);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (390, 6362, 3, 325.82, 1033, 1, 1015, 160);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (400, 5600, 3, 734.03, 1034, 3, 1016, 131);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (410, 9800, 3, 382.37, 1035, 4, 1021, 181);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (420, 4499, 3, 604.63, 1036, 7, 1011, 145);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (430, 8536, 3, 215.73, 1037, 6, 1015, 190);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (440, 3292, 3, 215.94, 1038, 4, 1030, 203);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (450, 9710, 3, 180.02, 1039, 8, 1017, 192);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (460, 3982, 3, 281.33, 1040, 3, 1021, 193);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (470, 5999, 3, 214.47, 1041, 6, 1011, 163);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (480, 3388, 3, 409.96, 1042, 8, 1024, 155);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (490, 9394, 3, 335.6, 1043, 9, 1014, 143);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (500, 5304, 3, 682.79, 1044, 3, 1029, 193);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (510, 6341, 3, 191.2, 1045, 4, 1024, 171);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (520, 2084, 3, 340.38, 1046, 1, 1020, 155);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (530, 9744, 3, 949.05, 1047, 3, 1025, 165);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (540, 6693, 3, 909.93, 1048, 7, 1013, 114);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (550, 1571, 3, 396.73, 1049, 4, 1011, 197);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (560, 2677, 3, 676.39, 1050, 9, 1028, 147);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (570, 2124, 3, 203.29, 1051, 5, 1011, 115);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (580, 2454, 3, 664.85, 1052, 7, 1021, 146);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (590, 7279, 3, 780.85, 1053, 3, 1012, 128);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (600, 8049, 3, 676.28, 1054, 4, 1012, 112);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (610, 2909, 3, 776.34, 1055, 7, 1017, 139);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (620, 1254, 3, 217.52, 1056, 5, 1015, 176);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (630, 8625, 3, 553.98, 1057, 6, 1011, 189);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (640, 4992, 3, 736.16, 1058, 1, 1017, 132);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (650, 9903, 3, 818.19, 1059, 2, 1028, 117);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (660, 8266, 3, 670.49, 1060, 7, 1019, 122);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (670, 6436, 3, 652.76, 1061, 6, 1025, 115);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (680, 8068, 3, 343.23, 1062, 3, 1011, 199);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (690, 2453, 3, 162.79, 1063, 8, 1012, 114);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (700, 6751, 3, 674.06, 1064, 6, 1020, 173);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (710, 7615, 3, 349.82, 1065, 2, 1030, 129);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (720, 2427, 3, 569.96, 1066, 4, 1019, 139);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (730, 5838, 3, 238.99, 1067, 8, 1014, 126);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (740, 2816, 3, 475.35, 1068, 2, 1021, 197);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (750, 5571, 3, 634.78, 1069, 9, 1023, 150);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (760, 5483, 3, 955.27, 1070, 3, 1013, 189);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (770, 8987, 3, 226.95, 1071, 3, 1019, 109);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (780, 9492, 3, 297.54, 1072, 2, 1029, 179);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (790, 4591, 3, 658.15, 1073, 1, 1030, 181);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (800, 8100, 3, 572.42, 1074, 2, 1028, 135);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (810, 3510, 3, 121.52, 1075, 5, 1011, 148);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (820, 1410, 3, 539.64, 1076, 7, 1026, 180);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (830, 4962, 3, 853.34, 1077, 9, 1028, 109);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (840, 8934, 3, 173.24, 1078, 5, 1013, 180);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (850, 2158, 3, 980.14, 1079, 3, 1019, 125);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (860, 7440, 3, 824.55, 1080, 5, 1022, 118);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (870, 1125, 3, 264.18, 1081, 2, 1022, 165);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (880, 4699, 3, 717.6, 1082, 2, 1011, 148);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (890, 2579, 3, 422.42, 1083, 9, 1016, 150);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (900, 7048, 3, 411.89, 1084, 8, 1022, 193);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (910, 9036, 3, 101.55, 1085, 3, 1017, 113);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (920, 8659, 3, 921.13, 1086, 4, 1026, 196);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (930, 1623, 3, 517.23, 1087, 5, 1021, 162);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (940, 8588, 3, 764.77, 1088, 4, 1028, 127);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (950, 6373, 3, 845.75, 1089, 9, 1028, 156);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (960, 8249, 3, 372.74, 1090, 2, 1025, 139);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (970, 6952, 3, 775.13, 1091, 4, 1021, 113);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (980, 8899, 3, 726.2, 1092, 7, 1028, 166);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (990, 1078, 3, 742.72, 1093, 3, 1026, 202);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1000, 6305, 3, 797.59, 1094, 9, 1026, 135);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1010, 1589, 3, 470.98, 1095, 1, 1025, 133);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1020, 1167, 3, 528.51, 1096, 3, 1017, 167);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1030, 7024, 3, 723.55, 1097, 1, 1020, 107);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1040, 5950, 3, 963.19, 1098, 2, 1030, 142);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1050, 9606, 3, 465.26, 1099, 2, 1018, 163);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id, calificacion_id) values (1060, 6329, 3, 803.41, 1100, 9, 1019, 145);


    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 10);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 20);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 30);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 40);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 50);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 60);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 70);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 80);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 90);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 100);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (6, 110);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 120);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 130);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 140);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 150);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 160);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 170);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 180);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 190);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 200);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 210);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 220);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 230);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 240);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 250);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 260);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 270);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 280);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 290);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 300);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 310);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 320);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 330);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 340);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 350);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 360);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 370);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 380);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 390);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 400);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 410);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 420);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (6, 430);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 440);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 450);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 460);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (6, 470);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 480);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 490);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 500);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 510);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 520);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 530);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 540);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 550);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 560);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 570);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 580);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 590);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 600);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 610);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 620);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (6, 630);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 640);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 650);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 660);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (6, 670);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 680);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 690);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (6, 700);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 710);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 720);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 730);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 740);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 750);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 760);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 770);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 780);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 790);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 800);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 810);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 820);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 830);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 840);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 850);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 860);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 870);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 880);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 890);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (8, 900);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 910);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 920);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (5, 930);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 940);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 950);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 960);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (4, 970);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (7, 980);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 990);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 1000);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 1010);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (3, 1020);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (1, 1030);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 1040);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (2, 1050);
    insert into FuncionEntity_BoletaEntity (FuncionEntity_ID, Boletas_ID)  values (9, 1060);
/* AbonoEntity */

    insert into AbonoEntity (id, precio, espectador_id) values (200,7000, 1011);

/*abonos de Espectador*/

    insert into PERSONAENTITY_ABONOENTITY (ESPECTADORENTITY_ID, ABONOS_ID) values (1011, 200);
