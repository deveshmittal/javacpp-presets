// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.ffmpeg.avutil;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.ffmpeg.global.avutil.*;


/**
 * Context structure for the Lagged Fibonacci PRNG.
 * The exact layout, types and content of this struct may change and should
 * not be accessed directly. Only its sizeof() is guranteed to stay the same
 * to allow easy instanciation.
 */
@Properties(inherit = org.bytedeco.ffmpeg.presets.avutil.class)
public class AVLFG extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public AVLFG() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public AVLFG(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AVLFG(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public AVLFG position(long position) {
        return (AVLFG)super.position(position);
    }

    public native @Cast("unsigned int") int state(int i); public native AVLFG state(int i, int setter);
    @MemberGetter public native @Cast("unsigned int*") IntPointer state();
    public native int index(); public native AVLFG index(int setter);
}
