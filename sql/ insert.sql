insert into role(name) values('редактор данных');
insert into rules(role_rights) values('использование карт');
insert into category(category) values('обновление данных');
insert into state(state) values('выполнено');
insert into users(name, role_id) values('Ivanov', 1);
insert into role_rules(role_id, rules_id) values(1, 1);
insert into item(item, users_id, category_id, state_id) values('внесение данных', 1, 1, 1);
insert into comments(comments_on_applications, item_id) values('выполненно 18.04.2022', 1);
insert into attachs(attached_files, item_id) values('акт выполненных работ', 1);
