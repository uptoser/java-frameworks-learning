package com.uptoser.ssm.concurrent.dao;

import com.uptoser.ssm.concurrent.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketDao {

	public int grapRedPacket(UserRedPacket userRedPacket);
}
