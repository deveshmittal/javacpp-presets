// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;

// #endif


//////////////////////////////// DMatch /////////////////////////////////

/** \brief Class for matching keypoint descriptors
<p>
query descriptor index, train descriptor index, train image index, and distance between
descriptors.
*/
@Namespace("cv") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class DMatch extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DMatch(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DMatch(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DMatch position(long position) {
        return (DMatch)super.position(position);
    }

    public DMatch() { super((Pointer)null); allocate(); }
    private native void allocate();
    public DMatch(int _queryIdx, int _trainIdx, float _distance) { super((Pointer)null); allocate(_queryIdx, _trainIdx, _distance); }
    private native void allocate(int _queryIdx, int _trainIdx, float _distance);
    public DMatch(int _queryIdx, int _trainIdx, int _imgIdx, float _distance) { super((Pointer)null); allocate(_queryIdx, _trainIdx, _imgIdx, _distance); }
    private native void allocate(int _queryIdx, int _trainIdx, int _imgIdx, float _distance);

    /** query descriptor index */
    public native int queryIdx(); public native DMatch queryIdx(int setter);
    /** train descriptor index */
    public native int trainIdx(); public native DMatch trainIdx(int setter);
    /** train image index */
    public native int imgIdx(); public native DMatch imgIdx(int setter);

    public native float distance(); public native DMatch distance(float setter);

    // less is better
    public native @Cast("bool") @Name("operator <") boolean lessThan(@Const @ByRef DMatch m);
}
