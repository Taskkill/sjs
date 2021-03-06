# sjs
Simple compiler from Symbolic JavaScript (Lisp-like language) to JavaScript. Created as semestral project.

## to run:
- install sbt
- `$ sbt`
- `compile`
- `run examples/code.sjs`

## to run compiled program:
- install node
- `$ node examples/code.mjs`

## example of Symbolic JavaScript code:
```lisp
(define sumlists (lista listb)
  (if  (null lista)
       nil
       (cons (* (car lista) (car listb))
             (sumlists (cdr lista) (cdr listb))
       )
  )
)

(define fact (n)
  (if (or (= n 0) (= n 1))
    1
    (* n (fact (- n 1)))
  )
)

(define map (list fn)
  (if (null list)
    nil
    (cons (fn (car list)) (map (cdr list) fn))
  )
)


(println "(sumlists `(1 2 3 4) `(3 2 1 5) )")
(println (sumlists `(1 2 3 4) `(3 2 1 5) ))

(println "(and true (or false true))")
(println (and true (or false true)))

(println "(map `(1 2 3 4 5) (lambda (n) (* n n)))")
(println (map `(1 2 3 4 5) (lambda (n) (* n n))))

(println "(fact 5)")
(println (fact 5))

(println "`(1 2 3 4 ,(* 6 (+ 2 3)))")
(println `(1 2 3 4 ,(* 6 (+ 2 3))))

(println "`(1 2 3 4 ,(* 6 (+ 2 `(23 24 25))))")
(println `(1 2 3 4 ,(* 6 (+ 2 `(23 24 25)))))
```

## example of JavaScript output:
```javascript
function sumlists  (lista, listb)  {
  return is_null(lista) ? []  :  [(car(lista) * car(listb)), ...sumlists(cdr(lista), cdr(listb))]
}

function fact  (n)  {
  return ((n === 0.0) || (n === 1.0)) ? 1.0  :  (n * fact((n - 1.0)))
}

function map  (list, fn)  {
  return is_null(list) ? []  :  [fn(car(list)), ...map(cdr(list), fn)]
}

println('(sumlists `(1 2 3 4) `(3 2 1 5) )')
println(sumlists([1.0, 2.0, 3.0, 4.0], [3.0, 2.0, 1.0, 5.0]))
println('(and true (or false true))')
println((true && (false || true)))
println('(map `(1 2 3 4 5) (lambda (n) (* n n)))')
println(map([1.0, 2.0, 3.0, 4.0, 5.0],  (n) => ((n * n)) ))
println('(fact 5)')
println(fact(5.0))
println('`(1 2 3 4 ,(* 6 (+ 2 3)))')
println([1.0, 2.0, 3.0, 4.0, (6.0 * (2.0 + 3.0))])
println('`(1 2 3 4 ,(* 6 (+ 2 `(23 24 25))))')
println([1.0, 2.0, 3.0, 4.0, (6.0 * (2.0 + [23.0, 24.0, 25.0]))])

///////////////////////////////////////////////////////
// THIS IS GENERATED BY THE COMPILER - DO NOT MODIFY //
///////////////////////////////////////////////////////
function is_null (x) {
  return (x instanceof Array) && (x.length === 0)
}

function car ([x, ...xs]) {
  return x
}

function cdr ([x, ...xs]) {
  return xs
}

function println (...args) {
  console.log(...args)
}
``` 
