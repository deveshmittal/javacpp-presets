// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;


@Namespace("cv::instr") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class NodeDataTls extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public NodeDataTls(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public NodeDataTls(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public NodeDataTls position(long position) {
        return (NodeDataTls)super.position(position);
    }

    public NodeDataTls() { super((Pointer)null); allocate(); }
    private native void allocate();
    public native @Cast("uint64") int m_ticksTotal(); public native NodeDataTls m_ticksTotal(int setter);
}
