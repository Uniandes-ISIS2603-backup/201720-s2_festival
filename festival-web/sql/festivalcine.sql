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
delete from CalificacionEntity;
delete from BoletaEntity;
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


delete from PeliculaEntity;
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director) values (1001, 'Batman', 'https://images-na.ssl-images-amazon.com/images/I/61sGxnXeqiL._SY550_.jpg', 33656, 'Drama|Thriller', 'Russia', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Hillie Whyman');
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director) values (1002, 'Tarzan', 'https://images-na.ssl-images-amazon.com/images/I/71ievnadZXL.SL1014.jpg', 3769, 'Action|Crime|Thriller', 'Hungary', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Rodrique Kaines');
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director) values (1003, 'Nemo', 'https://www.sonuit.fr/532/poster-mural-le-monde-de-nemo-panoramique-disney-komar.jpg', 749, 'Crime', 'Indonesia', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Liana Illsley');  
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director) values (1004, 'Coraline', 'http://s3.media.squarespace.com/production/465215/5307878/wp-content/uploads/2008/12/coraline1_large.jpg', 2589, 'Crime|Drama|Mystery|Thriller|War', 'Canada', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Devonne Beeston');  
    insert into PeliculaEntity (id, name, imagen, duracionMinutos, genero, pais, corto, director) values (1005, 'As above so Below', 'https://klling.files.wordpress.com/2017/07/as-above-so-below.jpg', 2880, 'Drama', 'Indonesia', 'https://www.youtube.com/embed/L_FONnnkdh4?ecver=2', 'Maudie Brandreth');


  



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



    /* boletas de Espectador*/
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1011, 10);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1012, 20);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1013, 30);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1014, 40);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1015, 50);
    insert into PERSONAENTITY_BOLETAENTITY (ESPECTADORENTITY_ID, BOLETAS_ID) values (1015, 60);

/* BoletaEntity*/
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(10, 120, 1, 500.50, 1, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(20, 130, 2, 600.50, 2, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(30, 110, 1, 700.50, 3, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id) values(40, 50, 3, 400.50, 4, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id) values(50, 500, 3, 400.50, 5, 2, 1011);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id, funcion_id, espectador_id) values(60, 650, 3, 300.25, 2, 3, 1012);

    /* CalificacionEntity */
    insert into CalificacionEntity (id,calificacion, comentario) values(1,1.1,'a1');
    insert into CalificacionEntity (id,calificacion, comentario) values(2,2.2,'a2');
    insert into CalificacionEntity (id,calificacion, comentario) values(3,3.3,'a3');
    insert into CalificacionEntity (id,calificacion, comentario) values(4,4.4,'a4');


    /* AbonoEntity */
    insert into AbonoEntity (id, precio, espectador_id) values (200,7000, 1011);
    /*abonos de Espectador*/
    insert into PERSONAENTITY_ABONOENTITY (ESPECTADORENTITY_ID, ABONOS_ID) values (1011, 200);
