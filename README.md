# `namespacefy`

# Introduction

namespacefy is a simple Clojure library which aims to make it easy to keep keys namespacefied.

When data is fetched from a database or received from an external system, the output is often a map with unnamespaced keywords. This is often the desired end result. However, to avoid naming conflicts, it is recommended to use namespaced keywords in Clojure. This library aims to solve this problem by providing simple helper functions to convert keys in maps to namespaced keywords. When the namespacing is not needed anymore, for example if you want to send it to your JSON-loving neighbour, unnamespacing can be done easily before JSON conversion.

# Installation

```clj
[namespacefy "0.1"]
```

# Usage

To namespacefy a map or a vector of maps, use the namespacefy function:


```clojure
(def data {:name "Seppo"
           :id 1
           :tasks {:id 666 :time 5}
           :points 7
           :foobar nil})

(namespacefy data {:ns :product.domain.player
                   :except #{:foobar}
                   :custom {:points :product.domain.point/points}
                   :inner {:tasks {:ns :product.domain.task}}})

;; We get the following output:
;; {:product.domain.player/name "player1"
;;  :product.domain.player/ip 1
;;  :product.domain.player/tasks {:product.domain.task/id 666
;;                                :product.domain.task/time 5}
;;  :product.domain.point/points 7
;;  :foobar nil}"
```

To unnamespacefy the sama data, use the unnamespacefy function:

```clojure
(unnamespacefy data)

;; We get the following output:
;; {:name "Seppo"
;;  :id 1
;;  :tasks {:id 666 :time 5}
;;  :points 7
;;  :foobar nil}
```

For more information on the available options, please read the function documentations.