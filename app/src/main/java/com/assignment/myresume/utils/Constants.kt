package com.assignment.myresume.utils

class Constants {
    class Messages {
        companion object {
            const val NO_INTERNET = "No internet"
            const val UNABLE_TO_FETCH_DATA = "Unable to fetch data"
            const val WORKING_HERE = "Working here"
        }
    }

    class IntentKeys {
        companion object {
            const val COMPANY_DETAIL_URL = "company_detail_url"
            const val COMPANY_NAME = "company_name"
            const val PROJECTS = "projects"
            const val PROJECT = "project"
        }
    }

    class StringValues {
        companion object {
            const val DASH_SPACE = "- "
            const val NEW_LINE = "\n"
        }
    }

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/RanaRanvijaySingh/"
        const val INVALID_REQUEST = "Invalid request"
    }
}