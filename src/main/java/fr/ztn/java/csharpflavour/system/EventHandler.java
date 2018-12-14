/*
  MIT License
  Copyright 2017 Sylvain Vernois
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.ztn.java.csharpflavour.system;

import java.util.LinkedList;
import java.util.List;

/**
 * Manages the registration and invocation of observers of an event.
 *
 * @param <TEventArgs> Class extending EventArgs.
 */
public class EventHandler<TEventArgs extends EventArgs> {
    private final List<IEventHandlerDelegate<TEventArgs>> eventMethods = new LinkedList<>();

    /**
     * Adds a new observer.
     *
     * @param method Implementation of the observer.
     */
    public void add(IEventHandlerDelegate<TEventArgs> method) {
        eventMethods.add(method);
    }

    /**
     * Removes an observer.
     *
     * @param method Reference of the observer.
     */
    public void remove(IEventHandlerDelegate method) {
        eventMethods.remove(method);
    }

    /**
     * Invokes all currently registered observers.
     *
     * @param sender    Object being the source of the event.
     * @param eventArgs Event data.
     */
    public void invoke(Object sender, TEventArgs eventArgs) {
        for (IEventHandlerDelegate<TEventArgs> eventMethod : eventMethods) {
            eventMethod.apply(sender, eventArgs);
        }
    }
}
