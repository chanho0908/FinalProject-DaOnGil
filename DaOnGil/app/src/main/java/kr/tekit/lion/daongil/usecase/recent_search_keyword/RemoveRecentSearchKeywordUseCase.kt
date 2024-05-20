package kr.tekit.lion.daongil.usecase.recent_search_keyword

import kr.tekit.lion.daongil.repository.recent_search_keyword.RecentSearchKeywordRepository

class RemoveRecentSearchKeywordUseCase(
    private val recentSearchKeywordRepository: RecentSearchKeywordRepository
) {
    suspend operator fun invoke(id: Long) {
        recentSearchKeywordRepository.removeRecentSearchKeyword(id)
    }
}