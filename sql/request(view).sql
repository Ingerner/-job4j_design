create view show_how_many_books_each_student_has
as select  s.name, count(b.name) from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
  	group by (s.name)
	order by s.name;
	
select * from show_how_many_books_each_student_has;

alter view show_how_many_books_each_student_has rename  to show_how_many_books_students_have_sorted_by_student_name;

select * from show_how_many_books_students_have_sorted_by_student_name;

drop view show_how_many_books_students_have_sorted_by_student_name;

select * from show_how_many_books_students_have_sorted_by_student_name;
	
	
	
	