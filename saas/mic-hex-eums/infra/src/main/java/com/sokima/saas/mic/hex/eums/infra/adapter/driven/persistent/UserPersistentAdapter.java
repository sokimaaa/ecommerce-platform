package com.sokima.saas.mic.hex.eums.infra.adapter.driven.persistent;

import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.inbound.user.InsertUserPersistentInPort;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.inbound.user.UpdateUserPersistentInPort;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.outbound.user.FindUserPersistentOutPort;

@DrivenAdapter
public class UserPersistentAdapter implements FindUserPersistentOutPort, InsertUserPersistentInPort, UpdateUserPersistentInPort {
}
