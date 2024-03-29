package com.viettel.vtskit.minio.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viettel.vtskit.minio.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.List;

@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    @Value("${server:}")
    private String server;

    @Value("${accessKey:}")
    private String accessKey;

    @Value("${secretKey:}")
    private String secretKey;

    @Value("${bucket:}")
    private String bucket;

    @Value("${autoCreateBucket:true}")
    private boolean autoCreateBucket;

    @JsonProperty("allow-type")
    private List<String> allowType;

    @JsonProperty("max-size")
    private Integer maxSize;

    private void validateProperties(){
        if(StringUtils.isNullOrEmpty(server)){
            throw new IllegalArgumentException("Please config MinIO server URL");
        }
        if(StringUtils.isNullOrEmpty(accessKey)){
            throw new IllegalArgumentException("Please config MinIO accessKey");
        }
        if(StringUtils.isNullOrEmpty(secretKey)){
            throw new IllegalArgumentException("Please config MinIO secretKey");
        }
        if(StringUtils.isNullOrEmpty(bucket)){
            throw new IllegalArgumentException("Please config MinIO bucket");
        }
        if(allowType == null || allowType.isEmpty()){
            throw new IllegalArgumentException("Please config MinIO allow type");
        }
        if(maxSize == null){
            throw new IllegalArgumentException("Please config MinIO max size");
        }

    }

    @PostConstruct
    void init(){
        validateProperties();
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public boolean isAutoCreateBucket() {
        return autoCreateBucket;
    }

    public void setAutoCreateBucket(boolean autoCreateBucket) {
        this.autoCreateBucket = autoCreateBucket;
    }

    public List<String> getAllowType() {
        return allowType;
    }

    public void setAllowType(List<String> allowType) {
        this.allowType = allowType;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
