/*
  MIT License
  Copyright 2017 Sylvain Vernois
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.ztn.java.csharpflavour;

/**
 * Defines a read only property ie. a value that can be publicly used through a getter and never publicly set.
 * Inspired by C# T PropertyName { get =&gt; aPrivateMember; }
 *
 * @param <T> Type of the value backed by the property.
 */
public class ReadOnlyProperty<T> {
    private final IPropertyGetter<T> _getter;

    /**
     * Creates a new read only property.
     *
     * @param getter Implementation of the getter.
     */
    public ReadOnlyProperty(IPropertyGetter<T> getter) {
        _getter = getter;
    }

    /**
     * @return Current value.
     */
    public T get() {
        return _getter.get();
    }
}
