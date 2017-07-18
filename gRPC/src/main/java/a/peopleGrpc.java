package a;

import io.grpc.stub.StreamObserver;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: people.proto")
public final class peopleGrpc {

  private peopleGrpc() {}

  public static final String SERVICE_NAME = "people";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<name,
      info> METHOD_GET_PEOPLE =
      io.grpc.MethodDescriptor.<name, info>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "people", "GetPeople"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              name.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              info.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static peopleStub newStub(io.grpc.Channel channel) {
    return new peopleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static peopleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new peopleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static peopleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new peopleFutureStub(channel);
  }

  /**
   */
  public static abstract class peopleImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPeople(name request,
        io.grpc.stub.StreamObserver<info> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PEOPLE, responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_PEOPLE,
            asyncUnaryCall(
              new MethodHandlers<
                name,
                info>(
                  this, METHODID_GET_PEOPLE)))
          .build();
    }


  }

  /**
   */
  public static final class peopleStub extends io.grpc.stub.AbstractStub<peopleStub> {
    private peopleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private peopleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected peopleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new peopleStub(channel, callOptions);
    }

    /**
     */
    public void getPeople(name request,
        io.grpc.stub.StreamObserver<info> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PEOPLE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class peopleBlockingStub extends io.grpc.stub.AbstractStub<peopleBlockingStub> {
    private peopleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private peopleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected peopleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new peopleBlockingStub(channel, callOptions);
    }

    /**
     */
    public info getPeople(name request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PEOPLE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class peopleFutureStub extends io.grpc.stub.AbstractStub<peopleFutureStub> {
    private peopleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private peopleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected peopleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new peopleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<info> getPeople(
        name request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PEOPLE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PEOPLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final peopleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(peopleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PEOPLE:
          serviceImpl.getPeople((name) request,
              (io.grpc.stub.StreamObserver<info>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class peopleDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return PeopleProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (peopleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new peopleDescriptorSupplier())
              .addMethod(METHOD_GET_PEOPLE)
              .build();
        }
      }
    }
    return result;
  }
}
