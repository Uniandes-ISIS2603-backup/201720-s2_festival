delete from FestivalEntity;
delete from BoletaEntity;

/* BoletaEntity*/
insert into BoletaEntity (id, codigoDeBarras, estado, precio) values(10, 120, 1, 500.50);
insert into BoletaEntity (id, codigoDeBarras, estado, precio) values(20, 130, 2, 600.50);
insert into BoletaEntity (id, codigoDeBarras, estado, precio) values(30, 110, 1, 700.50);
insert into BoletaEntity (id, codigoDeBarras, estado, precio) values(40, 50, 3, 400.50);
insert into BoletaEntity (id, codigoDeBarras, estado, precio) values(50, 650, 3, 300.25);
/*Funciones de BoletaEntity*/


/* SillaEntity */

    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 71.92, 0);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 97.06, 0);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (0, 64.79, 1);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 39.03, 1);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 23.65, 0);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 75.07, 1);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (0, 43.11, 1);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 88.15, 1);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 39.94, 0);
    insert into SillaEntity (reservada, tarifa, esPreferencial) values (1, 59.54, 1);

/* CriticaEntity */

    insert into CriticaEntity (comentario) values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.');
    insert into CriticaEntity (comentario) values ('In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.

    Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.

    Sed ante. Vivamus tortor. Duis mattis egestas metus.');
    insert into CriticaEntity (comentario) values ('Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.

    Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.');
    insert into CriticaEntity (comentario) values ('Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.

    Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.

    In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.');
    insert into CriticaEntity (comentario) values ('In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.

    Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.');
    insert into CriticaEntity (comentario) values ('Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.

    Phasellus in felis. Donec semper sapien a libero. Nam dui.

    Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.');
    insert into CriticaEntity (comentario) values ('Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.

    Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.');
    insert into CriticaEntity (comentario) values ('Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.

    Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

    Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.');
    insert into CriticaEntity (comentario) values ('Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.');
    insert into CriticaEntity (comentario) values ('Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.

    Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.');
