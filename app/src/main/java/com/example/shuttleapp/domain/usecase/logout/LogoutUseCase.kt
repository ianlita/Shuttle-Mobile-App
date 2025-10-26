package com.example.shuttleapp.domain.usecase.logout

import com.example.shuttleapp.domain.repository.UserDataRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke() {
        userDataRepository.clearUserData()
    }
}