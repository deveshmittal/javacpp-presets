// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.opencv.opencv_features2d;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.opencv.opencv_flann.*;
import static org.bytedeco.opencv.global.opencv_flann.*;

import static org.bytedeco.opencv.global.opencv_features2d.*;


/****************************************************************************************\
*                                  DescriptorMatcher                                     *
\****************************************************************************************/

/** \addtogroup features2d_match
/** \{
<p>
/** \brief Abstract base class for matching keypoint descriptors.
<p>
It has two groups of match methods: for matching descriptors of an image with another image or with
an image set.
 */
@Namespace("cv") @NoOffset @Properties(inherit = org.bytedeco.opencv.presets.opencv_features2d.class)
public class DescriptorMatcher extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DescriptorMatcher(Pointer p) { super(p); }

   /** enum cv::DescriptorMatcher::MatcherType */
   public static final int
        FLANNBASED            = 1,
        BRUTEFORCE            = 2,
        BRUTEFORCE_L1         = 3,
        BRUTEFORCE_HAMMING    = 4,
        BRUTEFORCE_HAMMINGLUT = 5,
        BRUTEFORCE_SL2        = 6;

    /** \brief Adds descriptors to train a CPU(trainDescCollectionis) or GPU(utrainDescCollectionis) descriptor
    collection.
    <p>
    If the collection is not empty, the new descriptors are added to existing train descriptors.
    <p>
    @param descriptors Descriptors to add. Each descriptors[i] is a set of descriptors from the same
    train image.
     */
    public native void add( @ByVal MatVector descriptors );
    public native void add( @ByVal UMatVector descriptors );
    public native void add( @ByVal GpuMatVector descriptors );

    /** \brief Returns a constant link to the train descriptor collection trainDescCollection .
     */
    public native @Const @ByRef MatVector getTrainDescriptors();

    /** \brief Clears the train descriptor collections.
     */
    public native @Override void clear();

    /** \brief Returns true if there are no train descriptors in the both collections.
     */
    public native @Cast("bool") @Override boolean empty();

    /** \brief Returns true if the descriptor matcher supports masking permissible matches.
     */
    public native @Cast("bool") boolean isMaskSupported();

    /** \brief Trains a descriptor matcher
    <p>
    Trains a descriptor matcher (for example, the flann index). In all methods to match, the method
    train() is run every time before matching. Some descriptor matchers (for example, BruteForceMatcher)
    have an empty implementation of this method. Other matchers really train their inner structures (for
    example, FlannBasedMatcher trains flann::Index ).
     */
    public native void train();

    /** \brief Finds the best match for each descriptor from a query set.
    <p>
    @param queryDescriptors Query set of descriptors.
    @param trainDescriptors Train set of descriptors. This set is not added to the train descriptors
    collection stored in the class object.
    @param matches Matches. If a query descriptor is masked out in mask , no match is added for this
    descriptor. So, matches size may be smaller than the query descriptors count.
    @param mask Mask specifying permissible matches between an input query and train matrices of
    descriptors.
    <p>
    In the first variant of this method, the train descriptors are passed as an input argument. In the
    second variant of the method, train descriptors collection that was set by DescriptorMatcher::add is
    used. Optional mask (or masks) can be passed to specify which query and training descriptors can be
    matched. Namely, queryDescriptors[i] can be matched with trainDescriptors[j] only if
    mask.at\<uchar\>(i,j) is non-zero.
     */
    public native void match( @ByVal Mat queryDescriptors, @ByVal Mat trainDescriptors,
                    @ByRef DMatchVector matches, @ByVal(nullValue = "cv::InputArray(cv::noArray())") Mat mask );
    public native void match( @ByVal Mat queryDescriptors, @ByVal Mat trainDescriptors,
                    @ByRef DMatchVector matches );
    public native void match( @ByVal UMat queryDescriptors, @ByVal UMat trainDescriptors,
                    @ByRef DMatchVector matches, @ByVal(nullValue = "cv::InputArray(cv::noArray())") UMat mask );
    public native void match( @ByVal UMat queryDescriptors, @ByVal UMat trainDescriptors,
                    @ByRef DMatchVector matches );
    public native void match( @ByVal GpuMat queryDescriptors, @ByVal GpuMat trainDescriptors,
                    @ByRef DMatchVector matches, @ByVal(nullValue = "cv::InputArray(cv::noArray())") GpuMat mask );
    public native void match( @ByVal GpuMat queryDescriptors, @ByVal GpuMat trainDescriptors,
                    @ByRef DMatchVector matches );

    /** \brief Finds the k best matches for each descriptor from a query set.
    <p>
    @param queryDescriptors Query set of descriptors.
    @param trainDescriptors Train set of descriptors. This set is not added to the train descriptors
    collection stored in the class object.
    @param mask Mask specifying permissible matches between an input query and train matrices of
    descriptors.
    @param matches Matches. Each matches[i] is k or less matches for the same query descriptor.
    @param k Count of best matches found per each query descriptor or less if a query descriptor has
    less than k possible matches in total.
    @param compactResult Parameter used when the mask (or masks) is not empty. If compactResult is
    false, the matches vector has the same size as queryDescriptors rows. If compactResult is true,
    the matches vector does not contain matches for fully masked-out query descriptors.
    <p>
    These extended variants of DescriptorMatcher::match methods find several best matches for each query
    descriptor. The matches are returned in the distance increasing order. See DescriptorMatcher::match
    for the details about query and train descriptors.
     */
    public native void knnMatch( @ByVal Mat queryDescriptors, @ByVal Mat trainDescriptors,
                       @ByRef DMatchVectorVector matches, int k,
                       @ByVal(nullValue = "cv::InputArray(cv::noArray())") Mat mask, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal Mat queryDescriptors, @ByVal Mat trainDescriptors,
                       @ByRef DMatchVectorVector matches, int k );
    public native void knnMatch( @ByVal UMat queryDescriptors, @ByVal UMat trainDescriptors,
                       @ByRef DMatchVectorVector matches, int k,
                       @ByVal(nullValue = "cv::InputArray(cv::noArray())") UMat mask, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal UMat queryDescriptors, @ByVal UMat trainDescriptors,
                       @ByRef DMatchVectorVector matches, int k );
    public native void knnMatch( @ByVal GpuMat queryDescriptors, @ByVal GpuMat trainDescriptors,
                       @ByRef DMatchVectorVector matches, int k,
                       @ByVal(nullValue = "cv::InputArray(cv::noArray())") GpuMat mask, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal GpuMat queryDescriptors, @ByVal GpuMat trainDescriptors,
                       @ByRef DMatchVectorVector matches, int k );

    /** \brief For each query descriptor, finds the training descriptors not farther than the specified distance.
    <p>
    @param queryDescriptors Query set of descriptors.
    @param trainDescriptors Train set of descriptors. This set is not added to the train descriptors
    collection stored in the class object.
    @param matches Found matches.
    @param compactResult Parameter used when the mask (or masks) is not empty. If compactResult is
    false, the matches vector has the same size as queryDescriptors rows. If compactResult is true,
    the matches vector does not contain matches for fully masked-out query descriptors.
    @param maxDistance Threshold for the distance between matched descriptors. Distance means here
    metric distance (e.g. Hamming distance), not the distance between coordinates (which is measured
    in Pixels)!
    @param mask Mask specifying permissible matches between an input query and train matrices of
    descriptors.
    <p>
    For each query descriptor, the methods find such training descriptors that the distance between the
    query descriptor and the training descriptor is equal or smaller than maxDistance. Found matches are
    returned in the distance increasing order.
     */
    public native void radiusMatch( @ByVal Mat queryDescriptors, @ByVal Mat trainDescriptors,
                          @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArray(cv::noArray())") Mat mask, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal Mat queryDescriptors, @ByVal Mat trainDescriptors,
                          @ByRef DMatchVectorVector matches, float maxDistance );
    public native void radiusMatch( @ByVal UMat queryDescriptors, @ByVal UMat trainDescriptors,
                          @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArray(cv::noArray())") UMat mask, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal UMat queryDescriptors, @ByVal UMat trainDescriptors,
                          @ByRef DMatchVectorVector matches, float maxDistance );
    public native void radiusMatch( @ByVal GpuMat queryDescriptors, @ByVal GpuMat trainDescriptors,
                          @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArray(cv::noArray())") GpuMat mask, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal GpuMat queryDescriptors, @ByVal GpuMat trainDescriptors,
                          @ByRef DMatchVectorVector matches, float maxDistance );

    /** \overload
    @param queryDescriptors Query set of descriptors.
    @param matches Matches. If a query descriptor is masked out in mask , no match is added for this
    descriptor. So, matches size may be smaller than the query descriptors count.
    @param masks Set of masks. Each masks[i] specifies permissible matches between the input query
    descriptors and stored train descriptors from the i-th image trainDescCollection[i].
    */
    public native void match( @ByVal Mat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks );
    public native void match( @ByVal Mat queryDescriptors, @ByRef DMatchVector matches );
    public native void match( @ByVal Mat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks );
    public native void match( @ByVal Mat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks );
    public native void match( @ByVal UMat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks );
    public native void match( @ByVal UMat queryDescriptors, @ByRef DMatchVector matches );
    public native void match( @ByVal UMat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks );
    public native void match( @ByVal UMat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks );
    public native void match( @ByVal GpuMat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks );
    public native void match( @ByVal GpuMat queryDescriptors, @ByRef DMatchVector matches );
    public native void match( @ByVal GpuMat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks );
    public native void match( @ByVal GpuMat queryDescriptors, @ByRef DMatchVector matches,
                            @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks );
    /** \overload
    @param queryDescriptors Query set of descriptors.
    @param matches Matches. Each matches[i] is k or less matches for the same query descriptor.
    @param k Count of best matches found per each query descriptor or less if a query descriptor has
    less than k possible matches in total.
    @param masks Set of masks. Each masks[i] specifies permissible matches between the input query
    descriptors and stored train descriptors from the i-th image trainDescCollection[i].
    @param compactResult Parameter used when the mask (or masks) is not empty. If compactResult is
    false, the matches vector has the same size as queryDescriptors rows. If compactResult is true,
    the matches vector does not contain matches for fully masked-out query descriptors.
    */
    public native void knnMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, int k );
    public native void knnMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, int k );
    public native void knnMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, int k );
    public native void knnMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void knnMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, int k,
                               @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    /** \overload
    @param queryDescriptors Query set of descriptors.
    @param matches Found matches.
    @param maxDistance Threshold for the distance between matched descriptors. Distance means here
    metric distance (e.g. Hamming distance), not the distance between coordinates (which is measured
    in Pixels)!
    @param masks Set of masks. Each masks[i] specifies permissible matches between the input query
    descriptors and stored train descriptors from the i-th image trainDescCollection[i].
    @param compactResult Parameter used when the mask (or masks) is not empty. If compactResult is
    false, the matches vector has the same size as queryDescriptors rows. If compactResult is true,
    the matches vector does not contain matches for fully masked-out query descriptors.
    */
    public native void radiusMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance );
    public native void radiusMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal Mat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance );
    public native void radiusMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal UMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") MatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance );
    public native void radiusMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") UMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );
    public native void radiusMatch( @ByVal GpuMat queryDescriptors, @ByRef DMatchVectorVector matches, float maxDistance,
                          @ByVal(nullValue = "cv::InputArrayOfArrays(cv::noArray())") GpuMatVector masks, @Cast("bool") boolean compactResult/*=false*/ );


    public native void write( @Str BytePointer fileName );
    public native void write( @Str String fileName );

    public native void read( @Str BytePointer fileName );
    public native void read( @Str String fileName );
    // Reads matcher object from a file node
    // see corresponding cv::Algorithm method
    public native @Override void read( @Const @ByRef FileNode arg0 );
    // Writes matcher object to a file storage
    public native @Override void write( @ByRef FileStorage arg0 );

    /** \brief Clones the matcher.
    <p>
    @param emptyTrainData If emptyTrainData is false, the method creates a deep copy of the object,
    that is, copies both parameters and train data. If emptyTrainData is true, the method creates an
    object copy with the current parameters but with empty train data.
     */
    public native @Ptr DescriptorMatcher clone( @Cast("bool") boolean emptyTrainData/*=false*/ );
    public native @Ptr DescriptorMatcher clone( );

    /** \brief Creates a descriptor matcher of a given type with the default parameters (using default
    constructor).
    <p>
    @param descriptorMatcherType Descriptor matcher type. Now the following matcher types are
    supported:
    -   {@code BruteForce} (it uses L2 )
    -   {@code BruteForce-L1}
    -   {@code BruteForce-Hamming}
    -   {@code BruteForce-Hamming(2)}
    -   {@code FlannBased}
     */
    public static native @Ptr DescriptorMatcher create( @Str BytePointer descriptorMatcherType );
    public static native @Ptr DescriptorMatcher create( @Str String descriptorMatcherType );

    public static native @Ptr DescriptorMatcher create( @Cast("const cv::DescriptorMatcher::MatcherType") int matcherType );


    // see corresponding cv::Algorithm method
    public native void write(@Ptr FileStorage fs, @Str BytePointer name/*=cv::String()*/);
    public native void write(@Ptr FileStorage fs, @Str String name/*=cv::String()*/);
}
