/*
  MIT License
  Copyright 2017 Sylvain Vernois
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.ztn.java.csharpflavour.system;

/**
 * Provides a set of methods allowing to measure elapsed time.
 */
public final class Stopwatch {
    private long _startTime;
    private long _stopTime;
    private boolean _isRunning;

    /// >> Public Methods

    /**
     * Creates a new instance.
     */
    public Stopwatch() {
        reset();
    }

    /**
     * Gets the total elapsed time measured by the current instance, in milliseconds.
     *
     * @return An integer representing the total number of milliseconds measured by the current instance.
     */
    public int getElapsedMilliseconds() {
        if (_isRunning) {
            return (int) (System.currentTimeMillis() - _startTime);
        } else {
            return (int) (_stopTime - _startTime);
        }
    }

    /**
     * Stops time interval measurement and resets the elapsed time to zero.
     */
    public void reset() {
        _isRunning = false;
        _startTime = 0;
        _stopTime = 0;
    }

    /**
     * Starts, or resumes, measuring elapsed time for an interval.
     */
    public void start() {
        _isRunning = true;
        _startTime = System.currentTimeMillis();
    }

    /**
     * Stops measuring elapsed time for an interval.
     */
    public void stop() {
        _stopTime = System.currentTimeMillis();
        _isRunning = false;
    }
}
