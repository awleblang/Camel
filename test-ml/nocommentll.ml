let rec length(alist : 'a list) = match alist with\n| [] -> 0\n| _::tl -> 1 + length tl;;\n\nlength( [5; 4; 3; 2; 1] );;