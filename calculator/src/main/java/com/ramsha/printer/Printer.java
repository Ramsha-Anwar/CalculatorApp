/**
 * © 2025 Ramsha Anwar. All rights reserved.
 *
 * Licensed under the MIT License.
 * You may obtain a copy of the License at
 *
 *     https://opensource.org/licenses/MIT
 */
package com.ramsha.printer;

/**
 * Interface for printing messages to output.
 * Provides a contract for different types of printers to implement message display functionality.
 */
public interface Printer 
{
    /**
     * Prints the specified message to the output.
     * @param message the message to be printed
     */
    void print(String message);
}
