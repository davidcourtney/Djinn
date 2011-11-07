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
 * Created: 10/26/11 9:35 PM
 */

package com.webguys.djinn.ifrit.metamodel;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class Cluster<T extends Action> extends MetaObject implements Type
{
    private List<T> members = Lists.newArrayList();

    public Cluster(String name)
    {
        super(name);
    }

    protected Iterable<T> getMembers()
    {
        return Collections.unmodifiableList(this.members);
    }

    public void addMember(T member)
    {
        this.members.add(member);
    }

    public boolean isMember(T action)
    {
        return this.members.contains(action);
    }

    public int memberCount()
    {
        return this.members.size();
    }

    @Override
    public String getTypeName()
    {
        return "Cluster";
    }
}