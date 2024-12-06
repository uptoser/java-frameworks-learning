package com.uptoser.ssm.concurrent.service;

public interface RedisRedPacketService {

	public void saveUserRedPacketByRedis(Long redPacketId, Double unitAmount);
}
