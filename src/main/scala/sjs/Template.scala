package template

object template {
  val builtins = """

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
  """
}
