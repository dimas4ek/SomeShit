create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 2 );

create table message (
    id bigint not null,
    author_name varchar(255),
    filename varchar(255),
    text varchar(2048) not null,
    user_id bigint,
    primary key (id))
    engine=InnoDB;

create table user_role (
    user_id bigint not null,
    roles varchar(255))
    engine=InnoDB;

create table usr (
    id bigint not null,
    activation_code varchar(255),
    active bit not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id))
    engine=InnoDB;

alter table message
    add constraint message_user_fk
    #add constraint FK70bv6o4exfe3fbrho7nuotopf - если сломается
    foreign key (user_id) references usr (id);

alter table user_role
    add constraint user_role_user_fk
    #add constraint FKfpm8swft53ulq2hl11yplpr5 - если сломается
    foreign key (user_id) references usr (id);