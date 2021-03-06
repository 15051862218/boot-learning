package com.syk.fastdfsspringbootstarter;


import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;

/**
 * @Author 沈永康
 * @Date 2022/4/14 20:48
 * @Version 1.0
 */

class FastDFSClient extends StorageClient1 {
    /**
     * 跟踪服务器
     */
    private TrackerServer trackerServer;
    /**
     * 存储服务器
     */
    private StorageServer storageServer;


    FastDFSClient(TrackerServer trackerServer,
                  StorageServer storageServer) {
        super(trackerServer, storageServer);
        this.trackerServer = trackerServer;
        this.storageServer = storageServer;
    }

    StorageClient1 getStorageClient1(){
        return new StorageClient1(this.trackerServer,this.storageServer);
    }

    TrackerServer getTrackerServer() {
        return this.trackerServer;
    }

    StorageServer getStorageServer() {
        return this.storageServer;
    }

}