// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.opencv.global.opencv_core.*;


/** \brief File Storage Node class.
<p>
The node is used to store each and every element of the file storage opened for reading. When
XML/YAML file is read, it is first parsed and stored in the memory as a hierarchical collection of
nodes. Each node can be a "leaf" that is contain a single number or a string, or be a collection of
other nodes. There can be named collections (mappings) where each element has a name and it is
accessed by a name, and ordered collections (sequences) where elements do not have names but rather
accessed by index. Type of the file node can be determined using FileNode::type method.
<p>
Note that file nodes are only used for navigating file storages opened for reading. When a file
storage is opened for writing, no data is stored in memory after it is written.
 */
@Namespace("cv") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_core.class)
public class FileNode extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileNode(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FileNode(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FileNode position(long position) {
        return (FileNode)super.position(position);
    }

    /** type of the file storage node */
    /** enum cv::FileNode:: */
    public static final int
        /** empty node */
        NONE      = 0,
        /** an integer */
        INT       = 1,
        /** floating-point number */
        REAL      = 2,
        /** synonym or REAL */
        FLOAT     = REAL,
        /** text string in UTF-8 encoding */
        STR       = 3,
        /** synonym for STR */
        STRING    = STR,
        /** sequence */
        SEQ       = 4,
        /** mapping */
        MAP       = 5,
        TYPE_MASK = 7,

        /** compact representation of a sequence or mapping. Used only by YAML writer */
        FLOW      = 8,
        /** if set, means that all the collection elements are numbers of the same type (real's or int's).
 *  UNIFORM is used only when reading FileStorage; FLOW is used only when writing. So they share the same bit */
        UNIFORM   = 8,
        /** empty structure (sequence or mapping) */
        EMPTY     = 16,
        /** the node has a name (i.e. it is element of a mapping). */
        NAMED     = 32;
    /** \brief The constructors.
     <p>
     These constructors are used to create a default file node, construct it from obsolete structures or
     from the another file node.
     */
    public FileNode() { super((Pointer)null); allocate(); }
    private native void allocate();

    /** \overload
     @param fs Pointer to the file storage structure.
     @param blockIdx Index of the memory block where the file node is stored
     @param ofs Offset in bytes from the beginning of the serialized storage
     */
    public FileNode(@Const FileStorage fs, @Cast("size_t") long blockIdx, @Cast("size_t") long ofs) { super((Pointer)null); allocate(fs, blockIdx, ofs); }
    private native void allocate(@Const FileStorage fs, @Cast("size_t") long blockIdx, @Cast("size_t") long ofs);

    /** \overload
     @param node File node to be used as initialization for the created file node.
     */
    public FileNode(@Const @ByRef FileNode node) { super((Pointer)null); allocate(node); }
    private native void allocate(@Const @ByRef FileNode node);

    /** \brief Returns element of a mapping node or a sequence node.
     @param nodename Name of an element in the mapping node.
     @return Returns the element with the given identifier.
     */
    public native @ByVal @Name("operator []") FileNode get(@Str BytePointer nodename);
    public native @ByVal @Name("operator []") FileNode get(@Str String nodename);

    /** \overload
     @param nodename Name of an element in the mapping node.
     */
    public native @ByVal @Name("operator []") FileNode getNode(@Cast("const char*") BytePointer nodename);
    public native @ByVal @Name("operator []") FileNode getNode(String nodename);

    /** \overload
     @param i Index of an element in the sequence node.
     */
    public native @ByVal @Name("operator []") FileNode at(int i);

    /** \brief Returns keys of a mapping node.
     @return Keys of a mapping node.
     */
    public native @ByVal StringVector keys();

    /** \brief Returns type of the node.
     @return Type of the node. See FileNode::Type
     */
    public native int type();

    /** returns true if the node is empty */
    public native @Cast("bool") boolean empty();
    /** returns true if the node is a "none" object */
    public native @Cast("bool") boolean isNone();
    /** returns true if the node is a sequence */
    public native @Cast("bool") boolean isSeq();
    /** returns true if the node is a mapping */
    public native @Cast("bool") boolean isMap();
    /** returns true if the node is an integer */
    public native @Cast("bool") boolean isInt();
    /** returns true if the node is a floating-point number */
    public native @Cast("bool") boolean isReal();
    /** returns true if the node is a text string */
    public native @Cast("bool") boolean isString();
    /** returns true if the node has a name */
    public native @Cast("bool") boolean isNamed();
    /** returns the node name or an empty string if the node is nameless */
    public native @StdString BytePointer name();
    /** returns the number of elements in the node, if it is a sequence or mapping, or 1 otherwise. */
    public native @Cast("size_t") long size();
    /** returns raw size of the FileNode in bytes */
    public native @Cast("size_t") long rawSize();
    /** returns the node content as an integer. If the node stores floating-point number, it is rounded. */
    public native @Name("operator int") int asInt();
    /** returns the node content as float */
    public native @Name("operator float") float asFloat();
    /** returns the node content as double */
    public native @Name("operator double") double asDouble();
    /** returns the node content as text string */
    public native @Name("operator std::string") @StdString BytePointer asBytePointer();

    public static native @Cast("bool") boolean isMap(int flags);
    public static native @Cast("bool") boolean isSeq(int flags);
    public static native @Cast("bool") boolean isCollection(int flags);
    public static native @Cast("bool") boolean isEmptyCollection(int flags);
    public static native @Cast("bool") boolean isFlow(int flags);

    public native @Cast("uchar*") BytePointer ptr();

    /** returns iterator pointing to the first node element */
    public native @ByVal FileNodeIterator begin();
    /** returns iterator pointing to the element following the last node element */
    public native @ByVal FileNodeIterator end();

    /** \brief Reads node elements to the buffer with the specified format.
     <p>
     Usually it is more convenient to use operator {@code >>} instead of this method.
     @param fmt Specification of each array element. See \ref format_spec "format specification"
     @param vec Pointer to the destination array.
     @param len Number of elements to read. If it is greater than number of remaining elements then all
     of them will be read.
     */
    public native void readRaw( @Str BytePointer fmt, Pointer vec, @Cast("size_t") long len );
    public native void readRaw( @Str String fmt, Pointer vec, @Cast("size_t") long len );

    /** Internal method used when reading FileStorage.
     Sets the type (int, real or string) and value of the previously created node.
     */
    public native void setValue( int type, @Const Pointer value, int len/*=-1*/ );
    public native void setValue( int type, @Const Pointer value );

    /** Simplified reading API to use with bindings. */
    public native double real();
    /** Simplified reading API to use with bindings. */
    public native @StdString BytePointer string();
    /** Simplified reading API to use with bindings. */
    public native @ByVal Mat mat();

    //protected:
    @MemberGetter public native @Const FileStorage fs();
    public native @Cast("size_t") long blockIdx(); public native FileNode blockIdx(long setter);
    public native @Cast("size_t") long ofs(); public native FileNode ofs(long setter);
}
