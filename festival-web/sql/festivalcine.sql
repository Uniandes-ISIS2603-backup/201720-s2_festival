delete from CriticaEntity;
delete from FuncionEntity;
delete from PeliculaEntity_PersonaEntity;
delete from PersonaEntity_PeliculaEntity;
delete from PeliculaEntity;
delete from PersonaEntity;
delete from CalificacionEntity;
delete from BoletaEntity;
delete from AbonoEntity;
delete from SillaEntity;
delete from FuncionEntity;
delete from SalaEntity;
delete from FestivalEntity;

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


/* BoletaEntity*/

    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id) values(10, 120, 1, 500.50, 1);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id) values(20, 130, 2, 600.50, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id) values(30, 110, 1, 700.50, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id) values(40, 50, 3, 400.50, 2);
    insert into BoletaEntity (id, codigoDeBarras, estado, precio, silla_id) values(50, 500, 3, 400.50, 2);


/*Funciones de BoletaEntity*/
insert into BoletaEntity (id, codigoDeBarras, estado, precio) values(60, 650, 3, 300.25);


/* CalificacionEntity */
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(1,1.1,'a1',10);
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(2,2.2,'a2',20);
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(3,3.3,'a3',30);
insert into CalificacionEntity (id,calificacion, comentario,boleta_id) values(4,4.4,'a4',40);

/* CriticoEntity */

    insert into PersonaEntity (name, dtype) values ('Brodie Gobel', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Hakim Woolforde', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Annecorinne Copcott', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Cesaro Sirette', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Sarine Brownbill', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Myca Lafontaine', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Dudley Carefull', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Uriah Harrie', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Dilan Maggorini', 'CriticoEntity');
    insert into PersonaEntity (name, dtype) values ('Abram Spennock', 'CriticoEntity');

    delete from PersonaEntity where dtype = 'CriticoEntity';

    insert into PersonaEntity (id, name, dtype) values (1, 'Inger Danielou', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (2, 'Muhammad Kerby', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (3, 'Poul Joselevitch', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (4, 'Chiarra Golland', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (5, 'Neile Beckhouse', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (6, 'Theresita Pickin', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (7, 'Flory Duggen', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (8, 'Rudie Aronsohn', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (9, 'Cash Matiasek', 'CriticoEntity');
    insert into PersonaEntity (id, name, dtype) values (10, 'Carmine Pessel', 'CriticoEntity');

/*PeliculaEntity*/
    
    insert into PeliculaEntity (name, director) values ('Chant of Jimmy Blacksmith, The', 'Tucker Gonsalvo');
    insert into PeliculaEntity (name, director) values ('Aces and Eights', 'Dean Minshull');
    insert into PeliculaEntity (name, director) values ('Giant Claw, The', 'Hagen Malcher');
    insert into PeliculaEntity (name, director) values ('Two-Way Stretch', 'Netti Philippeaux');
    insert into PeliculaEntity (name, director) values ('Dream With the Fishes', 'Rania Baumler');
    insert into PeliculaEntity (name, director) values ('Katt Williams: The Pimp Chronicles Pt. 1', 'Kipper Corona');
    insert into PeliculaEntity (name, director) values ('Giver, The', 'Averill Rolse');
    insert into PeliculaEntity (name, director) values ('My Own Private Idaho', 'Reider Tousey');
    insert into PeliculaEntity (name, director) values ('Hills Have Eyes, The', 'Hewitt Smullin');
    insert into PeliculaEntity (name, director) values ('Narrien illat ', 'Kassia Izkovitz');

                delete from PeliculaEntity;

    insert into PeliculaEntity (id, name, director) values (1, 'Presumed Guilty (Presunto culpable)', 'Laughton Dyhouse');
    insert into PeliculaEntity (id, name, director) values (2, 'Who Are the DeBolts? [And Where Did They Get 19 Kids?]', 'Carolan Hooks');
    insert into PeliculaEntity (id, name, director) values (3, 'Red', 'Seamus Priter');
    insert into PeliculaEntity (id, name, director) values (4, 'Apple, The (Sib)', 'Ethelin Losseljong');
    insert into PeliculaEntity (id, name, director) values (5, 'Copper Mountain', 'Basil Switzer');
    insert into PeliculaEntity (id, name, director) values (6, 'Lawnmower Man, The', 'Flossy Mack');
    insert into PeliculaEntity (id, name, director) values (7, 'Lightning Strikes Twice', 'Mureil Churn');
    insert into PeliculaEntity (id, name, director) values (8, 'Adventures of Prince Achmed, The (Abenteuer des Prinzen Achmed, Die)', 'Esmeralda Gingles');
    insert into PeliculaEntity (id, name, director) values (9, 'Journey from the Fall', 'Chas Maguire');
    insert into PeliculaEntity (id, name, director) values (10, 'Accident on Hill Road', 'Kathi Gun');

/*PersonaEntity - PeliculaEntity */

    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (1, 1);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (2, 2);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (3, 3);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (4, 4);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (5, 5);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (6, 6);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (7, 7);
    insert into PersonaEntity_PeliculaEntity (criticoentity_id, peliculas_id) values (8, 8);

/*PeliculaEntity - PersonaEntity */

    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (1, 1);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (2, 2);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (3, 3);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (4, 4);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (5, 5);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (6, 6);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (7, 7);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (8, 8);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (9, 9);
    insert into PeliculaEntity_PersonaEntity (peliculaentity_id, criticos_id) values (10, 10);

/* FuncionEntity */
  

    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('4/17/2017', '9/23/2016',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('12/16/2016', '10/12/2016',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('11/27/2016', '5/4/2017',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('12/28/2016', '7/27/2017',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('1/9/2017', '11/21/2016',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('7/10/2017', '2/25/2017',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('4/7/2017', '4/17/2017',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('12/15/2016', '3/23/2017',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('3/2/2017', '7/13/2017',1,1,1);
    insert into FuncionEntity (horaInicio, horaFin,sala_id,festival_id,pelicula_id) values ('10/18/2016', '12/28/2016',1,1,1);

    delete from FuncionEntity;

    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (1, '4/17/2017', '9/23/2016',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (2, '12/16/2016', '10/12/2016',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (3, '11/27/2016', '5/4/2017',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (4, '12/28/2016', '7/27/2017',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (5, '1/9/2017', '11/21/2016',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (6, '7/10/2017', '2/25/2017',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (7, '4/7/2017', '4/17/2017',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (8, '12/15/2016', '3/23/2017',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (9, '3/2/2017', '7/13/2017',1,1,1);
    insert into FuncionEntity (id, horaInicio, horaFin,sala_id,festival_id,pelicula_id) values (10, '10/18/2016', '12/28/2016',1,1,1);

/* CriticaEntity */

    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.

    Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.

    Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.

    In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Fusce consequat. Nulla nisl. Nunc nisl.

    Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.

    Sed ante. Vivamus tortor. Duis mattis egestas metus.

    Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', 1, 1);
    insert into CriticaEntity (comentario, critico_id, funcion_id) values ('Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 1, 1);

            delete from CriticaEntity;

    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (1, 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.

    Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

    Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (2, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.

    In congue. Etiam justo. Etiam pretium iaculis justo.

    In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (3, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (4, 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.

    Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

    Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (5, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.

    Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

    Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (6, 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.

    Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (7, 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.

    Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (8, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.

    Fusce consequat. Nulla nisl. Nunc nisl.

    Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (9, 'Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.

    Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.


    Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus ', 1, 1);
    insert into CriticaEntity (id, comentario, critico_id, funcion_id) values (10, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 1, 1);

