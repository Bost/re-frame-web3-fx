(defproject madvas.re-frame/web3-fx "0.1.6-2"
  :description "A re-frame effects handler for performing Ethereum Web3 API tasks"
  :url "https://github.com/madvas/re-frame-web3-fx"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojurescript "1.9.542"]
                 [cljs-web3 "0.19.0-0"]
                 [print-foo-cljs "2.0.3"]
                 [re-frame "0.9.3"]]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :figwheel {:server-port 6963}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :resource-paths []

  :profiles {:dev
             {:dependencies [[org.clojure/clojure "1.8.0"]
                             [binaryage/devtools "0.9.4"]
                             [com.cemerick/piggieback "0.2.1"]
                             [figwheel-sidecar "0.5.10"]
                             [org.clojure/tools.nrepl "0.2.13"]]
              :plugins [[lein-figwheel "0.5.8"]]
              :source-paths ["env/dev"]
              :resource-paths ["resources"]
              :cljsbuild {:builds [{:id "dev"
                                    :source-paths ["src" "test"]
                                    :figwheel {:on-jsload madvas.re-frame.test-runner/run}
                                    :compiler {:main madvas.re-frame.test-runner
                                               :output-to "resources/public/js/compiled/app.js"
                                               :output-dir "resources/public/js/compiled/out"
                                               :asset-path "/js/compiled/out"
                                               :source-map-timestamp true
                                               :optimizations :none
                                               :preloads [print.foo.preloads.devtools]
                                               }}]}}}

  )
