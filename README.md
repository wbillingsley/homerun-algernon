# HomeRun (aglernon)

This is a first attempt at creating something to help students run web examples in a local docker container.

"Algernon" is my usual tag for the first attempt at something. Bertie might or might not follow, depending on whether this architecture works out.

The code is not finished.

## Background

The Intelligent Book used to run all sorts of interesting AI models on the server that students would then interact with via diagrams on the web. Although more recently I've taken to compiling the models to JS and sending them to the client, that doesn't work for things that don't compile to JS.

For instance, if what I'm actually doing is teaching you Scala and you need to be able to write and run your own Scala.

The intent of HomeRun is that you run it inside a docker container, which is used as your local development environment. It listens for instructions that will be sent to it over CORS and confirmed by the user on a per-site basis with a short timeout at the command line. The docker container should only export the port to localhost so that only requests made from a browser on the same physical computer can be received. 
