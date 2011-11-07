/**
 * The MIT License
 *
 * Copyright (c) 2011 Kevin Birch <kevin.birch@gmail.com>. Some rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Created: 10/28/11 10:06 PM
 */

package com.webguys.djinn.marid.primitive.io;

import java.io.IOException;

import com.webguys.djinn.ifrit.model.Method;
import com.webguys.djinn.ifrit.model.ModuleFunction;
import com.webguys.djinn.ifrit.model.StringAtom;
import com.webguys.djinn.marid.primitive.BuiltinFactory;
import com.webguys.djinn.marid.primitive.NullaryFunction;
import com.webguys.djinn.marid.runtime.Context;
import com.webguys.djinn.marid.runtime.ExecutionException;
import com.webguys.djinn.marid.runtime.Stack;

public class Readln extends NullaryFunction
{
    public static final String NAME = "readln";

    public static final BuiltinFactory FACTORY = new BuiltinFactory()
    {
        @Override
        public ModuleFunction makeInstance(Method method)
        {
            return new Readln(method);
        }
    };

    public Readln(Method family)
    {
        super(NAME, family);
    }

    @Override
    public void execute(Context context)
    {
        Stack stack = context.getStack();

        try
        {
            stack.push(new StringAtom(context.getStdin().readLine()));
        }
        catch(IOException e)
        {
            throw new ExecutionException(NAME, e);
        }
    }
}