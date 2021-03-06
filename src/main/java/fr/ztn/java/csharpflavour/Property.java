/*
  MIT License
  Copyright 2017 Sylvain Vernois
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.ztn.java.csharpflavour;

import fr.ztn.java.csharpflavour.system.EventHandler;

/**
 * Defines a read and write property ie. a value that can only be publicly used through a getter and a setter.
 * Inspired by C# T PropertyName { get =&gt; somePrivateMember; set =&gt; somePrivateMember = value; } and enhanced for observability.
 *
 * @param <T> Type of the value backed by the property.
 */
public final class Property<T> extends ReadOnlyProperty<T> {
    private final IPropertySetter<T> _setter;

    /**
     * Creates a new property.
     *
     * @param getter Implementation of the getter.
     * @param setter Implementation of the setter.
     */
    public Property(IPropertyGetter<T> getter, IPropertySetter<T> setter) {
        super(getter);
        _setter = setter;
    }

    /**
     * Sets the value of the property.
     *
     * @param newValue Value to set.
     */
    public void set(T newValue) {
        _setter.set(newValue);
        onChanged.invoke(this, new PropertyChangedEventArgs<>(newValue));
    }

    /**
     * Event fired every time the value is changed / updated.
     */
    public final EventHandler<PropertyChangedEventArgs> onChanged = new EventHandler<>();
}
