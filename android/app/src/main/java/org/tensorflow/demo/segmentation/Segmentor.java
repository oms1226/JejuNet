/* Copyright 2015 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/

package org.tensorflow.demo.segmentation;

import android.graphics.Bitmap;

import java.util.Vector;

/**
 * Generic interface for interacting with different recognition engines.
 */
public interface Segmentor {
    /**
     * An immutable result returned by a Classifier describing what was recognized.
     */
    public class Segmentation {
        /**
         * A unique identifier for what has been recognized. Specific to the class, not the instance of
         * the object.
         */
        private final byte[] pixels;
        private final int numClass;
        private final int width;
        private final int height;
        private final long inferenceTime;
        private final long nativeTime;

        public Segmentation(
                final byte[] pixels2,
                final int numClass,
                final int width, final int height, final long inferenceTime, final long nativeTime) {
            this.pixels = pixels2;
            this.numClass = numClass;
            this.width = width;
            this.height = height;
            this.inferenceTime = inferenceTime;
            this.nativeTime = nativeTime;
        }

        public byte[] getPixels() { return pixels; }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public long getInferenceTime() {
            return inferenceTime;
        }

        public long getNativeTime() {
            return nativeTime;
        }

        public int getNumClass() {
            return numClass;
        }
    }

    Segmentation segmentImage(Bitmap bitmap);

    Vector<String> getLabels();
}
