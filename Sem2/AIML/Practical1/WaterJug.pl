% ============================================================
%  WATER JUG PROBLEM
%  Goal: Measure exactly 2 litres using a 4L jug and a 3L jug
%  State: water_jug(X, Y) where X = 4L jug, Y = 3L jug
% ============================================================

water_jug(X,Y):-X>4,Y<3,write('4l jug overloaded'),nl.
water_jug(X,Y):-X<4,Y>3,write('3l jug overloaded'),nl.
water_jug(X,Y):-X>4,Y>3,write('both jug overloaded'),nl.

% --- Entry Point ---
% Call water_jug(0, 0) to start the simulation.

water_jug(X,Y):- 
         (X=:=0,Y=:=0,nl,write('4L:0 & 3L:0 (Action: fill 3l jug.)'),YY is 3,water_jug(X,YY));
		 (X=:=0,Y=:=0,nl,write('4L:4 & 3L:0 (Action: fill 4l jug.)'),XX is 4,water_jug(XX,Y));
		 (X=:=2,Y=:=0,nl,write('4L:2 & 3L:0 (Action: goal.)'));
		 (X=:=4,Y=:=0,nl,write('4L:1 & 3L:3 (Action: 4l to 3l.)'),XX is X-3,YY is 3,water_jug(XX,YY));
		 (X=:=0,Y=:=3,nl,write('4L:3 & 3L:0 (Action: 3l to 4l.)'),XX is 3,YY is 0,water_jug(XX,YY));
	     (X=:=1,Y=:=3,nl,write('4L:1 & 3L:0 (Action: empty 3l.)'),YY is 0,water_jug(X,YY));
		 (X=:=3,Y=:=0,nl,write('4L:3 & 3L:3 (Action: fill 3l.)'),YY is 3,water_jug(X,YY));
		 (X=:=3,Y=:=3,nl,write('4L:4 & 3L:2 (Action: 3l to 4l.)'),XX is X+1,YY is Y-1,water_jug(XX,YY));
		 (X=:=1,Y=:=0,nl,write('4L:0 & 3L:1 (Action: 4l to 3l.)'),XX is Y,YY is X,water_jug(XX,YY));
		 (X=:=0,Y=:=1,nl,write('4L:4 & 3L:1 (Action: fill 4l.)'),XX is 4,water_jug(XX,Y));
		 (X=:=4,Y=:=1,nl,write('4L:2 & 3L:3 (Action: 4l to 3l.)'),XX is X-Y,YY is Y+2,water_jug(XX,YY));
		 (X=:=2,Y=:=3,nl,write('4L:2 & 3L:0 (Action: empty 3l.)'),YY is 0,water_jug(X,YY));
		 (X=:=4,Y=:=2,nl,write('4L:0 & 3L:2 (Action: empty 4l.)'),XX is 0,water_jug(XX,Y));
		 (X=:=0,Y=:=2,nl,write('4L:2 & 3L:0 (Action: 3l to 4l.)'),XX is Y,YY is X,water_jug(XX,YY)).



# Alternate Code
# % Water Jug Problem
# % Goal: Get exactly 2L in the 4L jug
# % State: water_jug(X, Y) — X = 4L jug, Y = 3L jug
# % Run: water_jug(0, 0)

# water_jug(0, 0) :-
#     write('(4L=0, 3L=0) Fill 3L jug'), nl,
#     water_jug(0, 3).

# water_jug(2, 0) :-
#     write('Goal reached: 4L=2, 3L=0'), nl.

# water_jug(0, 2) :-
#     write('(4L=0, 3L=2) Pour 3L into 4L'), nl,
#     water_jug(2, 0).

# water_jug(0, 3) :-
#     write('(4L=0, 3L=3) Pour 3L into 4L'), nl,
#     water_jug(3, 0).

# water_jug(3, 0) :-
#     write('(4L=3, 3L=0) Fill 3L jug'), nl,
#     water_jug(3, 3).

# water_jug(3, 3) :-
#     write('(4L=3, 3L=3) Pour 3L into 4L'), nl,
#     water_jug(4, 2).

# water_jug(4, 2) :-
#     write('(4L=4, 3L=2) Empty 4L jug'), nl,
#     water_jug(0, 2).
