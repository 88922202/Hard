#语法
expression
    :term
    |expression ADD term
    |expression SUB term
    ;
term
    :primary
    |term MUL primary
    |term DIV primary
    ;
primary
    :INT
    |FLOAT
    ;
#消除左递归后:
expression
    :term expression'
    ;
expression'
    :ADD term expression'
    |SUB term expression'
    |null
    ;
term
    :primary term'
    ;
term'
    :MUL primary term'
    |DIV primary term'
    |null
    ;
primary:
    :INT
    |FLOAT
    |null
    ;