delete from CriticaEntity;
delete from CalificacionEntity;
delete from AbonoEntity;
delete from BoletaEntity;
delete from FuncionEntity;
delete from PeliculaEntity_PersonaEntity;
delete from PersonaEntity_PeliculaEntity;
delete from PeliculaEntity;
delete from PersonaEntity;
delete from SillaEntity;
delete from CriticaEntity;
delete from PersonaEntity;
delete from FuncionEntity;
delete from SalaEntity;
delete from PeliculaEntity;
delete from FestivalEntity;

/*FestivalEntity*/
insert into FestivalEntity (id) values (1);


delete from FuncionEntity;
delete from SalaEntity;
delete from FestivalEntity;

delete from TeatroEntity;

delete from PeliculaEntity_FuncionEntity;
delete from PeliculaEntity;

/*FestivalEntity*/
insert into FestivalEntity (id) values (1);

/* SalaEntity */   

    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');
    insert into SalaEntity (name) values ('a');

    delete from SalaEntity;

    insert into SalaEntity (id) values (1);
    insert into SalaEntity (id) values (2);
    insert into SalaEntity (id) values (3);
    insert into SalaEntity (id) values (4);
    insert into SalaEntity (id) values (5);
    insert into SalaEntity (id) values (6);
    insert into SalaEntity (id) values (7);
    insert into SalaEntity (id) values (8);
    insert into SalaEntity (id) values (9);
    insert into SalaEntity (id) values (10);
/* BoletaEntity */
/* AbonoEntity */
    insert into AbonoEntity (id, precio) values (200,7000);
    insert into AbonoEntity (id, precio) values (333,3333);





/* FuncionEntity */
delete from FuncionEntity;

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


/* FuncionEntity */
  





/* CriticoEntity */


    delete from PersonaEntity where dtype = 'CriticoEntity';

    insert into PersonaEntity (id, name, dtype) values (1001, 'Inger Danielou', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1002, 'Muhammad Kerby', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1003, 'Poul Joselevitch', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1004, 'Chiarra Golland', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1005, 'Neile Beckhouse', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1006, 'Theresita Pickin', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1007, 'Flory Duggen', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1008, 'Rudie Aronsohn', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1009, 'Cash Matiasek', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (1010, 'Carmine Pessel', 'CriticoEntity' 
    delete from PersonaEntity where dtype = 'EspectadorEntity';

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

    delete from PeliculaEntity;
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1001, 'South, The (Lomalla)', 54, 33656, 'Drama|Thriller', 'Russia', 'https://goo.gl/ztJJlm', 'Hillie Whyman');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1002, 'Ricochet', 32, 3769, 'Action|Crime|Thriller', 'Hungary', 'https://goo.gl/of7uuS', 'Rodrique Kaines');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1003, 'Art of the Steal, The', 62, 749, 'Crime', 'Indonesia', 'https://goo.gl/oXrmyX', 'Liana Illsley');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1004, 'Joint Security Area (Gongdong gyeongbi guyeok JSA)', 70, 2589, 'Crime|Drama|Mystery|Thriller|War', 'Canada', 'https://goo.gl/WFzElk', 'Devonne Beeston');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1005, 'Month in the Country, A', 89, 2880, 'Drama', 'Indonesia', 'https://goo.gl/95GlK2', 'Maudie Brandreth');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1006, 'Denise Calls Up', 77, 10272, 'Comedy', 'France', 'https://goo.gl/LMieu0', 'Donia Pound');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1007, 'Les Invisibles', 21, 8752, 'Documentary', 'Iran', 'https://goo.gl/zlj0Pc', 'Robbie Friedank');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1008, 'For Love of Ivy', 97, 2160, 'Comedy|Drama|Romance', 'Malawi', 'https://goo.gl/graS0a', 'Astrix Boyington');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1009, 'Victor and the Secret of Crocodile Mansion', 26, 632, 'Adventure|Children|Mystery', 'China', 'https://goo.gl/pLVwrc', 'Berk Loch');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1010, 'Outrage', 3, 25400, 'Crime|Drama|Thriller', 'South Korea', 'https://goo.gl/9ZqCWL', 'Alden Dilworth');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1011, 'Blonde and Blonder', 59, 28024, 'Comedy|Crime', 'Japan', 'https://goo.gl/PDcsK7', 'Cele Di Bernardo');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1012, 'Little Witches', 53, 10272, 'Horror|Thriller', 'Ukraine', 'https://goo.gl/4lNwT7', 'Murvyn Duval');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1013, 'EXPO: Magic of the White City', 97, 27552, 'Documentary', 'China', 'https://goo.gl/GFQukr', 'Zorine Duddy');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1014, 'Whore', 30, 889, 'Drama', 'Philippines', 'https://goo.gl/aTvMQM', 'Ealasaid Kauffman');
    insert into PeliculaEntity (id, name, creditos, duracionMinutos, genero, pais, corto, director) values (1015, 'Iran vs EE.UU', 12, 889, 'Drama', 'EE.UU', 'https://www.youtube.com/embed/p1tO1p2Vl0w?ecver=2', 'Kauffman');

/*PersonaEntity - PeliculaEntity */

    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1001, 1001);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1002, 1002);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1003, 1003);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1004, 1004);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1005, 1005);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1006, 1006);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1007, 1007);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1007, 1008);

/*PeliculaEntity - PersonaEntity */

    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1001, 1001);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1002, 1002);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1003, 1003);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1004, 1004);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1005, 1005);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1006, 1006);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1007, 1007);
    insert into PeliculaEntity_PersonaEntity (peliculas_id, criticos_id) values (1007, 1008);

/* FuncionEntity */
  
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (1, 'Katalin Varga', '4/17/2017', '9/23/2016',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (2, 'Double Hour, The (La doppia ora)', '12/16/2016', '10/12/2016',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (3, 'Changeling, The', '11/27/2016', '5/4/2017',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (4, 'Recollections of the Yellow House (Recordações da Casa Amarela)', '12/28/2016', '7/27/2017',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (5, 'Lt. Robin Crusoe, U.S.N.', '1/9/2017', '11/21/2016',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (6, 'Zorro', '7/10/2017', '2/25/2017',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (7, 'Little Lili (La petite Lili)', '4/7/2017', '4/17/2017',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (8, 'Keeping the Promise (Sign of the Beaver, The)', '12/15/2016', '3/23/2017',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (9, 'Holokaustin värit', '3/2/2017', '7/13/2017',1,1,1001);
    insert into FuncionEntity (id, name, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (10, 'Panic Room', '10/18/2016', '12/28/2016',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id) values (11,'a11','4/17/2017', '9/23/2016',1,1);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (12,'a12','12/16/2016', '10/12/2016',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (13,'a13','11/27/2016', '5/4/2017',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (14,'a14','12/28/2016', '7/27/2017',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (15,'a15','1/9/2017', '11/21/2016',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (16,'a16','7/10/2017', '2/25/2017',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (17,'a17','4/7/2017', '4/17/2017',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (18,'a18','12/15/2016', '3/23/2017',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (19,'a19','3/2/2017', '7/13/2017',1,1,1001);
    insert into FuncionEntity (id, name,horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (20,'a20','2/18/2016', '12/28/2016',1,1,1001);

/* BoletaEntity*/
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(10, 120, 1, 500.50, 1, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(20, 130, 2, 600.50, 2, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(30, 110, 1, 700.50, 3, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(40, 50, 3, 400.50, 4, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(50, 500, 3, 400.50, 5, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(333, 333, 3, 333.33, 6, 2);

/*Funciones de BoletaEntity*/



/* CalificacionEntity */
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(1,1.1,'a1',10);
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(2,2.2,'a2',20);
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(3,3.3,'a3',30);
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(4,4.4,'a4',40);
   

/*Funciones de BoletaEntity*/
insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(60, 650, 3, 300.25, 5, 4);
    
/* AbonoEntity */
    insert into AbonoEntity (id, precio) values (200,7000);


/* CriticaEntity */

    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (1, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.

    Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

    Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1001, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (2, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.

    In congue. Etiam justo. Etiam pretium iaculis justo.

    In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 1001, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (3, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.', 1002, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (4, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.

    Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

    Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 1001, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (5, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.

    Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

    Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 1003, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (6, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.

    Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.', 1002, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (7, 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

    Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1001, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (8, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.

    Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 1004, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (9, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.

    Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.


    Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus ', 1001, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (10, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 1005, 1);


    /* TeatroEntity */
    insert into TeatroEntity(id, nombre, tarifaBasica) values (1, 'colombia', 8000);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (2, 'chapinero', 7000);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (3, 'colon', 7500);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (4, 'catellana', 8500);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (5, 'country', 9000);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (6, 'occidental' 8500);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (7, 'central' 7500);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (8, 'oriental' 7500);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (9, 'norte'9000);
    insert into TeatroEntity(id, nombre, tarifaBasica) values (10, 'sur' 8600);

   /* FestivalEnity*/
    insert into FestivalEntity(id, nombre, fechaInicio, fechaFin) values (1, 'verano', '8/20/2017','8/23/2017' );
    insert into FestivalEntity(id, nombre, fechaInicio, fechaFin) values (2, 'invierno', '8/24/2017','9/7/2017' );
    insert into FestivalEntity(id, nombre, fechaInicio, fechaFin) values (3, 'primavera', '9/8/2017','9/23/2017' );
    insert into FestivalEntity(id, nombre, fechaInicio, fechaFin) values (4, 'otonio', '9/24/2017','10/7/2017' );

    /* boletas de Espectador*/
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1011, 10);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1012, 20);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1013, 30);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1014, 40);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1015, 50);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1015, 60);

    /*abonos de Espectador*/

    insert into PERSONAENTITY_ABONOENTITY (ESPECTADORENTITY_ID, ABONOS_ID) values (1011, 200);
