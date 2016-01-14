[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/ "This project is not actively maintained")

To use this you'll need [SableCC 3](http://sablecc.org/).

    java -jar sablecc/lib/sablecc.jar objc2.sablecc3

And of course you'll have to write code that instantiates `Parser` and does something useful with it.

C source files using `typedef` cannot be parsed with parser that has lexer and parser nicely separated. As a temporary workaround, I've extended SableCC's parser to recognize some basic Cocoa types — see `net/pornel/objc2/hack/PreprocLexer.java`.

Grammar skips preprocessor rules. It's a good idea to use existing preprocessor with it, e.g.:

    gcc -E test.m

