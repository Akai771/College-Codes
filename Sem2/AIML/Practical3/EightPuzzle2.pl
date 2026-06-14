% ============================================================
% TOP-LEVEL PREDICATE: ids/0
% Entry point. Tries solution lengths N = 0, 1, 2, 3, ...
% ============================================================
ids :-
    start(State),            % Fetch the initial board state
    length(Moves, N),        % Generate a list of N unbound vars (N grows: 0, 1, 2, ...)
    dfs([State], Moves, Path), !,  % Try to find a solution path of exactly N moves
    show([start|Moves], Path),     % Print each step with its move name
    format('~nmoves = ~w~n', [N]). % Print total move count


% ============================================================
% DFS BASE CASE: we've used all allowed moves
% Check if current state is the goal; if so, reverse visited
% list into a forward Path
% ============================================================
dfs([State|States], [], Path) :-
    goal(State), !,                      % Current state must be the goal
    reverse([State|States], Path).       % States were pushed front-to-back; reverse for display


% ============================================================
% DFS RECURSIVE CASE: still have moves remaining
% Try each legal move, avoid revisiting states
% ============================================================
dfs([State|States], [Move|Moves], Path) :-
    move(State, Next, Move),             % Find a legal move from State → Next, named Move
    not(memberchk(Next, [State|States])),% Reject Next if it's already in our visited stack
    dfs([Next,State|States], Moves, Path). % Recurse: push Next onto the stack, consume one Move slot


% ============================================================
% DISPLAY: show each move name + board grid side by side
% show(MoveNames, States)
% ============================================================
show([], _).  % Base case: no more moves to display

show([Move|Moves], [State|States]) :-
    State = state(A,B,C,D,E,F,G,H,J),   % Destructure the 9-tile board
    format('~n~w~n~n', [Move]),          % Print the move name (e.g. 'right', 'down')
    format('~w ~w ~w~n', [A,B,C]),       % Print top row
    format('~w ~w ~w~n', [D,E,F]),       % Print middle row
    format('~w ~w ~w~n', [G,H,J]),       % Print bottom row
    show(Moves, States).                 % Recurse for remaining moves


% ============================================================
% INITIAL STATE  (6 1 3 / 4 * 5 / 7 2 0)
% * = blank tile, 0 = a numbered tile (not blank)
% ============================================================
start( state(6,1,3, 4,*,5, 7,2,0) ).


% ============================================================
% GOAL STATE  (* 0 1 / 2 3 4 / 5 6 7)
% ============================================================
goal( state(*,0,1, 2,3,4, 5,6,7) ).


% ============================================================
% MOVE RULES
% Each clause encodes one valid slide:
%   move(CurrentState, NextState, DirectionOfBlankMotion)
% The blank (*) moves; tiles slide the opposite way.
%
% Board positions are numbered like this:
%   A B C
%   D E F
%   G H J
% ============================================================

% --- Blank in position A (top-left) ---
move( state(*,B,C,D,E,F,G,H,J), state(B,*,C,D,E,F,G,H,J), right). % * swaps with B
move( state(*,B,C,D,E,F,G,H,J), state(D,B,C,*,E,F,G,H,J), down ).  % * swaps with D

% --- Blank in position B (top-middle) ---
move( state(A,*,C,D,E,F,G,H,J), state(*,A,C,D,E,F,G,H,J), left ).  % * swaps with A
move( state(A,*,C,D,E,F,G,H,J), state(A,C,*,D,E,F,G,H,J), right).  % * swaps with C
move( state(A,*,C,D,E,F,G,H,J), state(A,E,C,D,*,F,G,H,J), down ).  % * swaps with E

% --- Blank in position C (top-right) ---
move( state(A,B,*,D,E,F,G,H,J), state(A,*,B,D,E,F,G,H,J), left ).  % * swaps with B
move( state(A,B,*,D,E,F,G,H,J), state(A,B,F,D,E,*,G,H,J), down ).  % * swaps with F

% --- Blank in position D (middle-left) ---
move( state(A,B,C,*,E,F,G,H,J), state(*,B,C,A,E,F,G,H,J), up   ).  % * swaps with A
move( state(A,B,C,*,E,F,G,H,J), state(A,B,C,E,*,F,G,H,J), right).  % * swaps with E
move( state(A,B,C,*,E,F,G,H,J), state(A,B,C,G,E,F,*,H,J), down ).  % * swaps with G

% --- Blank in position E (center) ---
move( state(A,B,C,D,*,F,G,H,J), state(A,*,C,D,B,F,G,H,J), up   ).  % * swaps with B
move( state(A,B,C,D,*,F,G,H,J), state(A,B,C,D,F,*,G,H,J), right).  % * swaps with F
move( state(A,B,C,D,*,F,G,H,J), state(A,B,C,D,H,F,G,*,J), down ).  % * swaps with H
move( state(A,B,C,D,*,F,G,H,J), state(A,B,C,*,D,F,G,H,J), left ).  % * swaps with D

% --- Blank in position F (middle-right) ---
move( state(A,B,C,D,E,*,G,H,J), state(A,B,*,D,E,C,G,H,J), up   ).  % * swaps with C
move( state(A,B,C,D,E,*,G,H,J), state(A,B,C,D,*,E,G,H,J), left ).  % * swaps with E
move( state(A,B,C,D,E,*,G,H,J), state(A,B,C,D,E,J,G,H,*), down ).  % * swaps with J

% --- Blank in position G (bottom-left) ---
move( state(A,B,C,D,E,F,*,H,J), state(A,B,C,D,E,F,H,*,J), right).  % * swaps with H
move( state(A,B,C,D,E,F,*,H,J), state(A,B,C,*,E,F,D,H,J), up   ).  % * swaps with D

% --- Blank in position H (bottom-middle) ---
move( state(A,B,C,D,E,F,G,*,J), state(A,B,C,D,E,F,*,G,J), left ).  % * swaps with G
move( state(A,B,C,D,E,F,G,*,J), state(A,B,C,D,*,F,G,E,J), up   ).  % * swaps with E
move( state(A,B,C,D,E,F,G,*,J), state(A,B,C,D,E,F,G,J,*), right).  % * swaps with J

% --- Blank in position J (bottom-right) ---
move( state(A,B,C,D,E,F,G,H,*), state(A,B,C,D,E,*,G,H,F), up   ).  % * swaps with F
move( state(A,B,C,D,E,F,G,H,*), state(A,B,C,D,E,F,G,*,H), left ).  % * swaps with H
