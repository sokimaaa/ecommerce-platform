package com.sokima.infrastructure.microservice.eums.adapter.driven.persistent;

import com.sokima.domain.persistent.user.adapter.FindUserPersistentAdapter;
import com.sokima.domain.persistent.user.adapter.InsertUserPersistentAdapter;
import com.sokima.domain.persistent.user.adapter.UpdateUserPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class UserPersistentAdapter implements FindUserPersistentAdapter, InsertUserPersistentAdapter, UpdateUserPersistentAdapter {
}
