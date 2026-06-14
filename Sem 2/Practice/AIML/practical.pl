# Winning Combinations
ordered_line(1, 2, 3).
ordered_line(4, 5, 6).
ordered_line(7, 8, 9).
ordered_line(1, 4, 7).
ordered_line(2, 5, 8).
ordered_line(3, 6, 9).
ordered_line(1, 5, 9).
ordered_line(3, 5, 7).

line(A, B, C):- ordered_line(A, B, C).
line(A, B, C):- ordered_line(A, C, B).
line(A, B, C):- ordered_line(B, A, C).
line(A, B, C):- ordered_line(B, C, A).
line(A, B, C):- ordered_line(C, A, B).
line(A, B, C):- ordered_line(C, B, A).

full(A) :- x(A).
full(A) :- o(A).
empty(A) :- \+(full(A)).
same(A,A).
different(A,B) :- \+(same(A, B)).

% Move decision logic
move(C) :- rule1(C).
move(A) :- good(A), empty(A), !. 
good(1). good(3). good(7). good(9). % corners
good(5). % center
good(2). good(4). good(6). good(8). % sides

