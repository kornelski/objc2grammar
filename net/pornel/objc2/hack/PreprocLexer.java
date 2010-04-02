
package net.pornel.objc2.hack;

import net.pornel.objc2.analysis.*;
import net.pornel.objc2.parser.*;
import net.pornel.objc2.lexer.*;
import net.pornel.objc2.node.*;

import java.util.HashMap;
import java.io.PushbackReader;
import java.io.IOException;


public class PreprocLexer extends Lexer
{
    HashMap knownTypes;

    public PreprocLexer(PushbackReader z)
    {
        super(z);
        knownTypes = new HashMap();

        // This should be built by parsing typedefs

        knownTypes.put("NSArray",null);
        knownTypes.put("NSData",null);
        knownTypes.put("NSDictionary",null);
        knownTypes.put("NSEnumerator",null);
        knownTypes.put("NSError",null);
        knownTypes.put("NSFileHandle",null);
        knownTypes.put("NSMutableArray",null);
        knownTypes.put("NSMutableDictionary",null);
        knownTypes.put("NSMutableString",null);
        knownTypes.put("NSNotificationCenter",null);
        knownTypes.put("NSNumber",null);
        knownTypes.put("NSRange",null);
        knownTypes.put("NSString",null);
        knownTypes.put("NSStringEncoding",null);
        knownTypes.put("NSUInteger",null);
        knownTypes.put("NSURL",null);
    }

    @Override
    protected void filter() throws LexerException, IOException
    {
        if (this.token instanceof TIdent)
        {
            String name = this.token.getText();

            if (knownTypes.containsKey(name))
            {
                this.token = new TTypedefedIdent(name, this.token.getLine(), this.token.getPos());
            }
        }
    }
}

