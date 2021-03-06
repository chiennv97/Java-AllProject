// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: people.proto

/**
 * Protobuf type {@code infoData}
 */
public  final class infoData extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:infoData)
    infoDataOrBuilder {
  // Use infoData.newBuilder() to construct.
  private infoData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private infoData() {
    infoD_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private infoData(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              infoD_ = new java.util.ArrayList<info>();
              mutable_bitField0_ |= 0x00000001;
            }
            infoD_.add(
                input.readMessage(info.parser(), extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        infoD_ = java.util.Collections.unmodifiableList(infoD_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return PeopleProto.internal_static_infoData_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return PeopleProto.internal_static_infoData_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            infoData.class, infoData.Builder.class);
  }

  public static final int INFOD_FIELD_NUMBER = 1;
  private java.util.List<info> infoD_;
  /**
   * <code>repeated .info infoD = 1;</code>
   */
  public java.util.List<info> getInfoDList() {
    return infoD_;
  }
  /**
   * <code>repeated .info infoD = 1;</code>
   */
  public java.util.List<? extends infoOrBuilder> 
      getInfoDOrBuilderList() {
    return infoD_;
  }
  /**
   * <code>repeated .info infoD = 1;</code>
   */
  public int getInfoDCount() {
    return infoD_.size();
  }
  /**
   * <code>repeated .info infoD = 1;</code>
   */
  public info getInfoD(int index) {
    return infoD_.get(index);
  }
  /**
   * <code>repeated .info infoD = 1;</code>
   */
  public infoOrBuilder getInfoDOrBuilder(
      int index) {
    return infoD_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < infoD_.size(); i++) {
      output.writeMessage(1, infoD_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < infoD_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, infoD_.get(i));
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof infoData)) {
      return super.equals(obj);
    }
    infoData other = (infoData) obj;

    boolean result = true;
    result = result && getInfoDList()
        .equals(other.getInfoDList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getInfoDCount() > 0) {
      hash = (37 * hash) + INFOD_FIELD_NUMBER;
      hash = (53 * hash) + getInfoDList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static infoData parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static infoData parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static infoData parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static infoData parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static infoData parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static infoData parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static infoData parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static infoData parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static infoData parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static infoData parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static infoData parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static infoData parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(infoData prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code infoData}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:infoData)
      infoDataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return PeopleProto.internal_static_infoData_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return PeopleProto.internal_static_infoData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              infoData.class, infoData.Builder.class);
    }

    // Construct using infoData.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getInfoDFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      if (infoDBuilder_ == null) {
        infoD_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        infoDBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return PeopleProto.internal_static_infoData_descriptor;
    }

    public infoData getDefaultInstanceForType() {
      return infoData.getDefaultInstance();
    }

    public infoData build() {
      infoData result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public infoData buildPartial() {
      infoData result = new infoData(this);
      int from_bitField0_ = bitField0_;
      if (infoDBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          infoD_ = java.util.Collections.unmodifiableList(infoD_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.infoD_ = infoD_;
      } else {
        result.infoD_ = infoDBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof infoData) {
        return mergeFrom((infoData)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(infoData other) {
      if (other == infoData.getDefaultInstance()) return this;
      if (infoDBuilder_ == null) {
        if (!other.infoD_.isEmpty()) {
          if (infoD_.isEmpty()) {
            infoD_ = other.infoD_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureInfoDIsMutable();
            infoD_.addAll(other.infoD_);
          }
          onChanged();
        }
      } else {
        if (!other.infoD_.isEmpty()) {
          if (infoDBuilder_.isEmpty()) {
            infoDBuilder_.dispose();
            infoDBuilder_ = null;
            infoD_ = other.infoD_;
            bitField0_ = (bitField0_ & ~0x00000001);
            infoDBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getInfoDFieldBuilder() : null;
          } else {
            infoDBuilder_.addAllMessages(other.infoD_);
          }
        }
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      infoData parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (infoData) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<info> infoD_ =
      java.util.Collections.emptyList();
    private void ensureInfoDIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        infoD_ = new java.util.ArrayList<info>(infoD_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        info, info.Builder, infoOrBuilder> infoDBuilder_;

    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public java.util.List<info> getInfoDList() {
      if (infoDBuilder_ == null) {
        return java.util.Collections.unmodifiableList(infoD_);
      } else {
        return infoDBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public int getInfoDCount() {
      if (infoDBuilder_ == null) {
        return infoD_.size();
      } else {
        return infoDBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public info getInfoD(int index) {
      if (infoDBuilder_ == null) {
        return infoD_.get(index);
      } else {
        return infoDBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder setInfoD(
        int index, info value) {
      if (infoDBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoDIsMutable();
        infoD_.set(index, value);
        onChanged();
      } else {
        infoDBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder setInfoD(
        int index, info.Builder builderForValue) {
      if (infoDBuilder_ == null) {
        ensureInfoDIsMutable();
        infoD_.set(index, builderForValue.build());
        onChanged();
      } else {
        infoDBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder addInfoD(info value) {
      if (infoDBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoDIsMutable();
        infoD_.add(value);
        onChanged();
      } else {
        infoDBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder addInfoD(
        int index, info value) {
      if (infoDBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureInfoDIsMutable();
        infoD_.add(index, value);
        onChanged();
      } else {
        infoDBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder addInfoD(
        info.Builder builderForValue) {
      if (infoDBuilder_ == null) {
        ensureInfoDIsMutable();
        infoD_.add(builderForValue.build());
        onChanged();
      } else {
        infoDBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder addInfoD(
        int index, info.Builder builderForValue) {
      if (infoDBuilder_ == null) {
        ensureInfoDIsMutable();
        infoD_.add(index, builderForValue.build());
        onChanged();
      } else {
        infoDBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder addAllInfoD(
        java.lang.Iterable<? extends info> values) {
      if (infoDBuilder_ == null) {
        ensureInfoDIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, infoD_);
        onChanged();
      } else {
        infoDBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder clearInfoD() {
      if (infoDBuilder_ == null) {
        infoD_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        infoDBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public Builder removeInfoD(int index) {
      if (infoDBuilder_ == null) {
        ensureInfoDIsMutable();
        infoD_.remove(index);
        onChanged();
      } else {
        infoDBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public info.Builder getInfoDBuilder(
        int index) {
      return getInfoDFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public infoOrBuilder getInfoDOrBuilder(
        int index) {
      if (infoDBuilder_ == null) {
        return infoD_.get(index);  } else {
        return infoDBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public java.util.List<? extends infoOrBuilder> 
         getInfoDOrBuilderList() {
      if (infoDBuilder_ != null) {
        return infoDBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(infoD_);
      }
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public info.Builder addInfoDBuilder() {
      return getInfoDFieldBuilder().addBuilder(
          info.getDefaultInstance());
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public info.Builder addInfoDBuilder(
        int index) {
      return getInfoDFieldBuilder().addBuilder(
          index, info.getDefaultInstance());
    }
    /**
     * <code>repeated .info infoD = 1;</code>
     */
    public java.util.List<info.Builder> 
         getInfoDBuilderList() {
      return getInfoDFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        info, info.Builder, infoOrBuilder> 
        getInfoDFieldBuilder() {
      if (infoDBuilder_ == null) {
        infoDBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            info, info.Builder, infoOrBuilder>(
                infoD_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        infoD_ = null;
      }
      return infoDBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:infoData)
  }

  // @@protoc_insertion_point(class_scope:infoData)
  private static final infoData DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new infoData();
  }

  public static infoData getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<infoData>
      PARSER = new com.google.protobuf.AbstractParser<infoData>() {
    public infoData parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new infoData(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<infoData> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<infoData> getParserForType() {
    return PARSER;
  }

  public infoData getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

