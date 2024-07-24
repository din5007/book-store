import { render } from "@testing-library/react";
import userEvent from '@testing-library/user-event';
import { describe, expect, it, vi } from "vitest";
import SearchBook from "./Search";

describe('Search Component', () => {
    it('Search Component should load properly - snapshot', async () => {
        const mock = vi.fn();
        const {container}  = render(<SearchBook onChange={mock}/>);
        expect(container).toMatchSnapshot();
    });

    it('Search Component should load properly', async () => {
        const mock = vi.fn();
        const {getByPlaceholderText}  = render(<SearchBook onChange={mock}/>);
        const input = getByPlaceholderText('Search by Book Name');
        await userEvent.type(input, 'book');
        expect(mock).toBeCalled()
    });
})