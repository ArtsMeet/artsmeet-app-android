package com.artsmeet.app.core.datasource.authentication.impl

import com.artsmeet.app.core.datasource.authentication.FetchUserDataSource
import com.artsmeet.app.core.datasource.base.BaseDataSource
import com.artsmeet.app.core.service.authentication.FetchUserService
import javax.inject.Inject

class FetchUserDataSourceImpl @Inject constructor(
    private val fetchUserService: FetchUserService
) : BaseDataSource(), FetchUserDataSource {

    override suspend fun fetchUser(uid: String) = fetchUserService.getUser(uid)
}