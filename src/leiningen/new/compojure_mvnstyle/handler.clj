(ns {{namespace}}.handler)

(defmacro defhandler
  [name args & body]
  `(defn ~name [req#]
     (let [{:keys ~args :or {~'req req#}} (:params req#)]
       ~@body)))

(defhandler hello [name]
  (str "Hello, " name))
