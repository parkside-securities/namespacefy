(defproject namespacefy "0.4"
  :description "Helper library for namespacing keywords"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}}
  :url "https://github.com/Jarzka/namespacefy"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :source-paths ["src"]
  :test-paths ["test"]
  :plugins [[lein-codox "0.10.3"]]
  :codox {:output-path "docs"})