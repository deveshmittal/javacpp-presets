// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;



/** \brief This is a base class for all more or less complex algorithms in OpenCV
<p>
especially for classes of algorithms, for which there can be multiple implementations. The examples
are stereo correspondence (for which there are algorithms like block matching, semi-global block
matching, graph-cut etc.), background subtraction (which can be done using mixture-of-gaussians
models, codebook-based algorithm etc.), optical flow (block matching, Lucas-Kanade, Horn-Schunck
etc.).
<p>
Here is example of SimpleBlobDetector use in your application via Algorithm interface:
\snippet snippets/core_various.cpp Algorithm
*/
@Namespace("cv") @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class Algorithm extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Algorithm(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Algorithm(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Algorithm position(long position) {
        return (Algorithm)super.position(position);
    }

    public Algorithm() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** \brief Clears the algorithm state
    */
    public native void clear();

    /** \brief Stores algorithm parameters in a file storage
    */
    public native void write(@ByRef FileStorage fs);

    /** \brief simplified API for language bindings
    * \overload
    */
    public native void write(@Ptr FileStorage fs, @Str BytePointer name/*=cv::String()*/);
    public native void write(@Ptr FileStorage fs, @Str String name/*=cv::String()*/);

    /** \brief Reads algorithm parameters from a file storage
    */
    public native void read(@Const @ByRef FileNode fn);

    /** \brief Returns true if the Algorithm is empty (e.g. in the very beginning or after unsuccessful read
    */
    public native @Cast("bool") boolean empty();

    /** \brief Reads algorithm from the file node
    <p>
    This is static template method of Algorithm. It's usage is following (in the case of SVM):
    <pre>{@code
    cv::FileStorage fsRead("example.xml", FileStorage::READ);
    Ptr<SVM> svm = Algorithm::read<SVM>(fsRead.root());
    }</pre>
    In order to make this method work, the derived class must overwrite Algorithm::read(const
    FileNode& fn) and also have static create() method without parameters
    (or with all the optional parameters)
    */

    /** \brief Loads algorithm from the file
    <p>
    @param filename Name of the file to read.
    @param objname The optional name of the node to read (if empty, the first top-level node will be used)
    <p>
    This is static template method of Algorithm. It's usage is following (in the case of SVM):
    <pre>{@code
    Ptr<SVM> svm = Algorithm::load<SVM>("my_svm_model.xml");
    }</pre>
    In order to make this method work, the derived class must overwrite Algorithm::read(const
    FileNode& fn).
    */

    /** \brief Loads algorithm from a String
    <p>
    @param strModel The string variable containing the model you want to load.
    @param objname The optional name of the node to read (if empty, the first top-level node will be used)
    <p>
    This is static template method of Algorithm. It's usage is following (in the case of SVM):
    <pre>{@code
    Ptr<SVM> svm = Algorithm::loadFromString<SVM>(myStringModel);
    }</pre>
    */

    /** Saves the algorithm to a file.
    In order to make this method work, the derived class must implement Algorithm::write(FileStorage& fs). */
    public native void save(@Str BytePointer filename);
    public native void save(@Str String filename);

    /** Returns the algorithm string identifier.
    This string is used as top level xml/yml node tag when the object is saved to a file or string. */
    public native @Str BytePointer getDefaultName();
}
